
/*
 * @author NeerajSingh
 *
 */
////////////////////////////////////////////////////////////
package kfkproducer;



import java.io.*;
import java.util.*;
import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;


/*
 * 
 * This program accessses the model data for Portfolio/Trades and puts them into Kafka topic "ptrades". 
 * For proof of concept, a subset of  model data has been dumped into txt file.
 */


public class rsysKafkaProducer {

        final private String fileName = "Benchmark-Portfolio.txt.txt";

	public static void main(String[] args) throws IOException {
		
		Properties props = new Properties();
		props.put("metadata.broker.list", "localhost:9092");
		props.put("serializer.class", "kafka.serializer.StringEncoder");
		props.put("partitioner.class", "kfkproducer.CustomPartitioner");
		props.put("request.required.acks", "1");

		ProducerConfig config = new ProducerConfig(props);
		Producer<String, String> producer = new Producer<String, String>(config);

                Scanner scan = null;
		String trade = null;
                long events =0;
		try {                
		    scan = new Scanner(new BufferedReader(new FileReader( "Benchmark-Portfolio.txt.txt" )));
		    
		    while (scan.hasNextLine() ) {                    
		        String tid = scan.next();
		        String wkn = scan.next();
		        String tdate = scan.next();
		        String vdate = scan.next();
		        Double nominal = scan.nextDouble();
		        Double price = scan.nextDouble();
		        String inst = scan.next();
		        String company = scan.next();
		        String desk = scan.next();
		        String book = scan.next();
                        events++;
                        
		        trade = tid + ", "+ wkn + ", "+ tdate + ", "+ vdate + ", "+  nominal + ", "+ price + ", "
		               + inst + ", "+ company + ", "+ desk + ", "+ book  ;
		        
		        System.out.println( trade );  

			// Configure the data and topic together as keyedMessage to be sent to Kafka//
			KeyedMessage<String, String> keytrade= new KeyedMessage<String, String>(
					"ptrades", trade);  

			producer.send(keytrade);
                        
		     }
		} finally {
		    if (scan != null) {
		        scan.close();
		    }
		}	
		
		producer.close();
	}
}




