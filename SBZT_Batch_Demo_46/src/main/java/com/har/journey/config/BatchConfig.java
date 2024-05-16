package com.har.journey.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.har.journey.listener.MyJobExecutionListener;
import com.har.journey.processor.MyItemProcessor;
import com.har.journey.reader.MyItemReader;
import com.har.journey.writer.MyItemWriter;

@Configuration
@EnableBatchProcessing   // To Enable & to create object's
public class BatchConfig {

//	 1. ItemReader Object
	@Bean
	public ItemReader<String> reader(){
		return new MyItemReader();
	}
	
//	 2.ItemProcesor Object
	 @Bean
	 public ItemProcessor<String, String> processor(){
		 return new MyItemProcessor();
	 }
	
//	 3.ItemWriter Object
	 @Bean
	 public ItemWriter<String> writer(){
		 return new MyItemWriter();
	 }
	 
//	 4.JobExecutionListener Object
	 @Bean
	 public JobExecutionListener listener() {
		 return new MyJobExecutionListener();
	 }
	 
//	5.StepBuilderFactory from SpringContainer by using @Autowired
	@Autowired
	private StepBuilderFactory sbf;
	 
//	6.Step Object by using StepBuilderFactory. Inputs :[name,chunk(size),reader,processor,writer]
	
	public Step stepA() {
		return sbf.get("StepA")                //Step Name
				   .<String,String>chunk(10)    //Chunk size
				   .reader(reader())
				   .processor(processor())
				   .writer(writer())
				   .build();
 	}

//	7.JobBuilderFactory from  SpringContainer by using @Autowired
	@Autowired
	private JobBuilderFactory jbf;
	
//	8.Job object from JobBuilderFactory . Inputs[name,incrementer,JobExecutionListener obj,start step,next step...n step]
    @Bean
	public Job jobA() {
    	return jbf.get("JobA")                  //Job Name
    			  .listener(listener())         //Job Listener
    			  .incrementer(new RunIdIncrementer()) //Incrementer 
    			  .start(stepA())                       //Start step
    		     //.next(stepB())                       // next Step .....n Step
    			//.next(stepC())  
    			  .build();
    }
	
	
	
}
