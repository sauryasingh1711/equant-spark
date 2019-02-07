@author: Neeraj Singh
# equant-spark
Spark based Enterprise Quant Analytics

Follow the steps mentioned below to run the complete project.


++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

1- Kafka

1-a) start zookeeper:  
  bin/zookeeper-server-start.sh config/zookeeper.properties

1-b) start kafka: 
  bin/kafka-server-start.sh config/server.properties

1-c Create topic: 
  bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic ptrades salestopic

1-d Test Kafka: send receive message :
  bin/kafka-console-producer.sh --broker-list localhost:9092 --topic ptrades

(Enter some dummy trades.)
FID_150		113740	900000000	99,983	schatz	bm_bund		eigenbestand	bestand_fa
PFID_151	113740	2600000000	99,983	schatz	bm_bund		emissionen	tender_aufst
PFID_152	113740	2900000000	99,983	schatz	bm_bund		emissionen	tender_aufst


> bin/kafka-console-consumer.sh --zookeeper localhost:2181 --topic ptrades --from-beginning

(Dummy trades should appear here !)
FID_150		113740	900000000	99,983	schatz	bm_bund		eigenbestand	bestand_fa
PFID_151	113740	2600000000	99,983	schatz	bm_bund		emissionen	tender_aufst
PFID_152	113740	2900000000	99,983	schatz	bm_bund		emissionen	tender_aufst

*** If it all works out, Kafka is ready to serve the job. ***
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

2- Hbase

2-a) start hbase:  
bin/start-hbase.sh;  

2-b) connect to hbase -> ./bin/hbase shell;

2-c) create table-> hbase(main):001:0> create 'tradesporfolio', 'InstPortfolioPV'

2-d) hbase(main):006:0> scan 'tradesporfolio'

*** If it all works out, Hbase is ready to serve the job. ***
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 
3) rsysKafkaProducer (Client)

3-a)Start eclipse and select the workspace. Create a java project with folder rsysKafkaProducer. 
3-b)Load all the java files (rsysKafkaProducer.java and CustomPartitioner.java) and txt files as resources. 

Alternatively, just unzip the rsysKafkaProducer.zip and open it as java project of eclipse.

3-c)Go to project proerties, add the external jar files of Kafka. 
3-d)Build the project rsysKafkaProducer. Run rsysKafkaProducer.java as Java application.


*** If it all works out, the console of Kafka-consumer should show the trades of Benchmark portfolio. It implies, 
KafkaProducer is fully ready. ***
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

4) rtQuantAnalytics (Spark Computation Engine)

3-a)Scala is required to run this project.
3-b)just unzip the rtQuantAnalytics.zip. It has the sbt build files with all required configurations.
3-c)Type in <  sbt clean; sbt compile; sbt package;  >

3-d)If everything works fine with building the project, type in <  sbt run  >

*** If it all works out, scan the  Hbase as in step 2-d. scan 'tradesporfolio' will show the PV for Benchmark portfolio.
Our analytics engine rtQuantAnalytics is fully ready. ***
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++



5) VisualizerObba

5-1) Install Obba and Apache POI
5-2) Run Obba Server - < java -jar Obba.jar >
5-3) Load the java files into project and include the XSSF POI and Obba Jars. Compile it.
5-4) Open the Excel file <ExtendedObbaMoreTestCases.xlsx>
5-5) Select 10 rows and run the macros { =obGet( obCall("Ptf";"poiGenExcelBeanXSSF";"displayHbaseToExcelXSSF") ) }
 
*** It should show the PV of Instrument+Company based Portfolio computed by Spark. *****
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
Over & All
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
