package com.gumgum.mr;

import java.io.IOException;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.TextOutputFormat;


public class Main 
{
    public static void main( String[] args ) throws IOException
    {
    	 JobConf conf = new JobConf(Main.class);
    	 conf.setJobName("gumgummr");
    	 conf.setOutputKeyClass(Text.class);
    	 conf.setOutputValueClass(MultiWritable.class);
    	 
    	 conf.setMapOutputKeyClass(Text.class);
    	 conf.setMapOutputValueClass(MultiWritable.class);
    	 
    	  	
    	conf.setMapperClass(JsonMapper.class);
    	conf.setCombinerClass(JSONReducer.class);
    	conf.setReducerClass(JSONReducer.class);
    	  	
    	conf.setInputFormat(TextInputFormat.class);
    	conf.setOutputFormat(TextOutputFormat.class);
    	   	  	
    	 FileInputFormat.setInputPaths(conf, new Path(args[0]));
    	 FileOutputFormat.setOutputPath(conf, new Path(args[1]));
    	 	
    	 JobClient.runJob(conf);
    	

        
    }
   
}
