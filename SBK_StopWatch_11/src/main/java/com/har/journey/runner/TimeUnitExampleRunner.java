package com.har.journey.runner;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TimeUnitExampleRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("TimeUnitExampleRunner.run()");
		// TimeUnit.FROM.toMethod(value)
		// Days->Hrs
		System.out.println(TimeUnit.DAYS.toHours(3));
		System.out.println(TimeUnit.DAYS.toMinutes(3));
		System.out.println(TimeUnit.DAYS.toSeconds(3));
		System.out.println(TimeUnit.DAYS.toMillis(3));
		System.out.println();

		// Hrs->Days
		System.out.println(TimeUnit.HOURS.toDays(48));
		System.out.println(TimeUnit.HOURS.toDays(12));
		System.out.println();

		// Mins->Secs
		System.out.println(TimeUnit.MINUTES.toSeconds(2));
		System.out.println();

		// Secs-->Millis
		System.out.println(TimeUnit.SECONDS.toMicros(1));
		System.out.println(TimeUnit.SECONDS.toMicros(1));

	}

}
