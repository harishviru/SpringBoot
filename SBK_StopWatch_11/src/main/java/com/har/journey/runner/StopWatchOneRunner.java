package com.har.journey.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
public class StopWatchOneRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
      System.out.println("StopWatchOneRunner.run()");
		StopWatch watch = new StopWatch();

		watch.start();
		for (int i = 0; i < 100000000; i++) {
			double result = Math.pow(i + 1, i) + Math.pow(3, i);
		}
		watch.stop();
		System.out.println("Time in Milli secs :"+watch.getTotalTimeMillis());
		System.out.println("Time in secs :"+watch.getTotalTimeSeconds());
		System.out.println("Time in secs :"+watch.prettyPrint());

	}

}
