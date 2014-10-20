package com.gumgum.mr;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class JSONReducer extends MapReduceBase implements Reducer<Text, MultiWritable, Text, MultiWritable>{

	public void reduce(Text key, Iterator<MultiWritable> values, OutputCollector<Text, MultiWritable> output, Reporter reporter)throws IOException {
		 
		MultiWritable out = new MultiWritable();;
		
		while(values.hasNext()){
			
			out.combine(values.next());
			if(out.a.get()>0)
				output.collect(key, out);
		}
	}
	
	

}
