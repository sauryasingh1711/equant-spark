// rtQuantAnalytics.scala //

import kafka.serializer.StringDecoder
import org.apache.spark._
import org.apache.spark.streaming._
import org.apache.spark.streaming.StreamingContext._
import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileSystem, Path}
import StreamingContext._
import org.apache.spark.streaming.kafka.KafkaUtils
import org.apache.hadoop.hbase.HBaseConfiguration
import org.apache.hadoop.hbase.mapreduce.TableOutputFormat
import org.apache.hadoop.io.{FloatWritable, Writable, Text}
import org.apache.hadoop.hbase.client.{Put}
import org.apache.hadoop.hbase.util.Bytes
import org.apache.spark.streaming.kafka.HasOffsetRanges
import org.apache.spark.streaming.kafka._


object TradePricingRealTime {

  def main(args: Array[String]) {

    val sparkConf = new SparkConf().setAppName("Portfolio Trade Pricing in Real Time").setMaster("local[2]")
    val ssc = new StreamingContext(sparkConf, Seconds(30))
    val hadoopConf = new org.apache.hadoop.conf.Configuration()
    val hdfs = FileSystem.get(new java.net.URI("hdfs://localhost:8020"), hadoopConf)
 

    // Create direct kafka stream with brokers and topics

    val brokers = "localhost:9092"
    val topics = "ptrades"
    val topicsSet = topics.split(",").toSet
    val kafkaParams = Map[String, String]("metadata.broker.list" -> brokers)

    val messages = KafkaUtils.createDirectStream[String, String, StringDecoder, StringDecoder](

                                            ssc, kafkaParams, topicsSet)

    val trades = messages.map(_._2)
    ssc.checkpoint("hdfs://localhost:8020/TradePricing/checkpoints")
 

    val tradesDataRDD = trades.map(row => {

      val columnValues = row.split(",")
      val tid = columnValues(0)
      val wkn = columnValues(1)           
      val tdate = columnValues(2)
      val vdate = columnValues(3)
      val nominal = columnValues(4).toFloat
      val price = columnValues(5).toFloat   
      val inst = columnValues(6)     
      val company = columnValues(7)
      val desk = columnValues(8)
      val book = columnValues(9)


    //Compute the present value of security using Black-Scholes for sec-price, price over time //
    // interest r= 0.03, Volatility(sigma)=0.013, time (T)=5 yrs //

      val pv = callPrice(price,price+2.0, 0.03, 0.013, 5)
      ((vdate, inst,company),pv)

    })

 

    // Group the PV-position based on instrument, valuta-date,for each sub-type portfolio based on company.
    val instPVCount = tradesDataRDD.reduceByKey(_ + _)
    val instPVPosition = instPVCount.updateStateByKey(doSumCBFunction _)

    instPVPosition.foreachRDD ( rdd => {

      val conf = HBaseConfiguration.create()
      conf.set(TableOutputFormat.OUTPUT_TABLE, "tradesporfolio")
      conf.set("hbase.zookeeper.quorum","localhost:2222")
      conf.set("hbase.rootdir", "/usr/lib/hbase-0.96.2-hadoop2")
      val jobConf = new Configuration(conf)
      jobConf.set("mapreduce.job.output.key.class", classOf[Text].getName)
      jobConf.set("mapreduce.job.output.value.class", classOf[FloatWritable].getName)
      jobConf.set("mapreduce.outputformat.class", classOf[TableOutputFormat[Text]].getName)
      rdd.map(serialize).saveAsNewAPIHadoopDataset(jobConf)

    })

    instPVPosition.map(a => a._1._1 + "," + a._1._2 + "," + a._1._3 + "," + a._2).print()
    ssc.start()
    ssc.awaitTermination()

  }


// Quant Financial library functions//

def callPrice(S: Double, X: Double, r: Double, sigma: Double, T: Double): Double = {
  import org.apache.commons.math3.analysis.function.Gaussian

  val sigmaT = sigma * Math.sqrt(T)
  val d1 = (Math.log(S/X) + (r*T + 0.5*sigmaT*sigmaT) /sigmaT)
  val d2 = d1 - sigmaT
  val gauss = new Gaussian
  S* gauss.value(d1 - X*Math.exp(-r*T)*gauss.value(d2))
}

def monteCarlo(state: Double, maxIters: Int) : Option[Double] = {
  import org.apache.commons.math3.analysis.function.Gaussian
  val coefs = 0.01
  val sigma = 0.035
  val r= 0.004
  val sigmaT = sigma * Math.sqrt(coefs)
  val alpha1 = Math.exp(r*coefs)
  val alpha2 = coefs*Math.exp(- 0.5*sigmaT*sigmaT)
  val theta = alpha1*alpha2
  val delta = Math.exp( sigmaT)

  val gauss = new Gaussian
  val totalValues = Range(0, maxIters).scanLeft(0.0)((_, n) => 
     theta*Math.pow(delta, gauss.value(0.03))).takeWhile( _ > coefs)

  if( totalValues.size < maxIters)
     Some(alpha1 *totalValues.last / maxIters)
  else
     None

}
 

// Some utility functions//

  def serialize(t: ((String,String,String), Double)) = {
    val p = new Put(Bytes.toBytes(t._1._1 + "-" + t._1._2 + "-" + t._1._3 ))
    p.add(Bytes.toBytes("count"), Bytes.toBytes("salescount"), (t._2).toString().getBytes())
    (t._1, p)

  }

  def doSumCBFunction(values:Seq[Double], runningCount:Option[Double]) = {
      val newCount = values.sum + runningCount.getOrElse(0.0)
      new Some(newCount)
  }

}
