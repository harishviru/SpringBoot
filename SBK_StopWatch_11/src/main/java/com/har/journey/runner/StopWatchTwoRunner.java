package com.har.journey.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
public class StopWatchTwoRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
       System.out.println("StopWatchTwoRunner.run()");
		
		StopWatch watch = new StopWatch("StopWatchTwoRunner");

		watch.start("Loop#1"); //taskName
		for (int i = 0; i < 10000000; i++) {
			double result = Math.pow(i + 1, i) + Math.pow(3, i);
		}
		watch.stop();
		
		//skip
		for (int i = 0; i < 100000000; i++) {
			double result = Math.pow(i + 1, i) + Math.pow(3, i);
		}
		
		watch.start("Loop#2"); //taskName
		for (int i = 0; i < 10000000; i++) {
			double result = Math.pow(i + 1, i) + Math.pow(3, i);
		}
		watch.stop();
		
		System.out.println("Time in Milli secs :"+watch.getTotalTimeMillis());
		System.out.println("Time in secs :"+watch.getTotalTimeSeconds());
		System.out.println("Time in secs :"+watch.prettyPrint());

	}

}
