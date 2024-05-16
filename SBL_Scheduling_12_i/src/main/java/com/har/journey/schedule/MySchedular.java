package com.har.journey.schedule;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MySchedular {

	@Scheduled(fixedDelay = 5000) //1000Milli secs =1sec
	public void m1() {
		System.out.println("m1 :"+new Date());
	}
	
}
