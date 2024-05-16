package com.har.journey.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class MyJobExecutionListener implements JobExecutionListener {

	private long startTime;
	
	@Override
	public void beforeJob(JobExecution je) {
		System.out.println("Before starting Job :"+je.getStatus());
		startTime = System.currentTimeMillis();
	}
	
	@Override
	public void afterJob(JobExecution je) {
	      System.out.println("After Finishing Job :"+je.getStatus());
	      long endTime = System.currentTimeMillis();
	      System.out.println("Total time taken to finish "+je.getJobInstance().getJobName() +" is :"+(endTime-startTime));
	}
	
	
}
