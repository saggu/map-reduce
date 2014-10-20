package com.gumgum.mr;

import java.io.IOException;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class JsonMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text , MultiWritable>{

	private MultiWritable collector;
	private static final int one = 1;
	private static final int zero = 0;
	
	private Text pvID = new Text();;
	
	
	public void map(LongWritable key, Text value, OutputCollector<Text, MultiWritable> output , Reporter reporter) throws IOException {
		
		String line = value.toString();
		
		line = "[" + line.substring(32,line.length()) + "]";
		
		JSONArray jArr = (JSONArray) JSONSerializer.toJSON(line);
		
		JSONObject pvObj = jArr.getJSONObject(1);
		
		if(pvObj.containsKey("e") && pvObj.getString("e").equals("click") && pvObj.containsKey("pv")) {
			
				collector = new MultiWritable(zero, zero,one);
				pvID.set(pvObj.getString("pv"));
				output.collect(pvID, collector);
		}
		else if(pvObj.containsKey("e") && pvObj.getString("e").equals("view") && pvObj.containsKey("pv")){
				collector = new MultiWritable(zero,one,zero);
				pvID.set(pvObj.getString("pv"));
				output.collect(pvID, collector);
				
			}
		else if(pvObj.containsKey("pv")){
			collector = new MultiWritable(one,zero,zero);
			pvID.set(pvObj.getString("pv"));
			output.collect(pvID, collector);
		}
		
		
	}
	
}
