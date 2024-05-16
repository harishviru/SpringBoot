package com.har.journey.runner;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyJobLauncher implements CommandLineRunner {

	@Autowired
	private JobLauncher jobLauncher;
	@Autowired
	private Job job;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println(".STARTED......................");
		JobParameters jobParameters =new JobParametersBuilder()
				            .addString("1", "MySQL_TO_CSV_ii").toJobParameters();
		jobLauncher.run(job, jobParameters);
	}

}
