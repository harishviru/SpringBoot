package com.har.journey.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class MyJobExecutionListener implements JobExecutionListener {

	long startTime =0;
	
	@Override
	public void beforeJob(JobExecution je) {
		System.out.println("Before Starting Job :"+je.getStatus());
		startTime =System.currentTimeMillis();
	}
	
	@Override
	public void afterJob(JobExecution je) {
		System.out.println("After Finishing Job :"+je.getStatus());
		long endTime =System.currentTimeMillis();
		System.out.println("Time Taken to complete the Job is "+(endTime-startTime));
	}
	
}
