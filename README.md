map-reduce
==========


Instructions to run the map reduce job ,

1. Let HADOOP_HOME be the locally installed Hadoop directory
2. Create a folder named 'ggmr' under HADOOP_HOME
2. Create a folder named 'in' under HADOOP_HOME/ggmr
3. Copy the input file to HADOOP_HOME/ggmr/in
4. Copy the ggmr.jar to HADOOP_HOME/ggmr
5. Make sure the jars -  json-lib-2.3-jdk15.jar and ezmorph-1.0.6.jar are in the classpath
6. Change directory to HADOOP_HOME
6. run the job using the command - bin/hadoop jar ggmr/ggmr.jar com.gumgum.mr.Main ggmr/in/ ggmr/out
	
