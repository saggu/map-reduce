package com.gumgum.mr;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Writable;

public class MultiWritable implements Writable{
	
	IntWritable a;
	IntWritable v;
	IntWritable c;
	
	
	
	public MultiWritable(int a,int v, int c){
	
		this.a = new IntWritable(a);
		this.v = new IntWritable(v);
		this.c = new IntWritable(c);
		
		
	}
	
	public MultiWritable(){
		
		this.a = new IntWritable(0);
		this.v = new IntWritable(0);
		this.c = new IntWritable(0);
		
		
	}
	

	public void readFields(DataInput input) throws IOException {

		a.readFields(input);
		v.readFields(input);
		c.readFields(input);
		
	}
	
	public void combine(MultiWritable m){
		
		this.a = new IntWritable(this.a.get() + m.a.get());
		this.v = new IntWritable(this.v.get() + m.v.get());
		this.c = new IntWritable(this.c.get() + m.c.get());
		
	}

	public void write(DataOutput output) throws IOException {
		
		a.write(output);
		v.write(output);
		c.write(output);
				
	}
	
	@Override
	public String toString(){
		return this.a + "\t" + this.v + "\t" + this.c;
	}

}
