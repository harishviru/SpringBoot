package com.har.journey.runner;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(9)
public class MessageRunner implements CommandLineRunner{
	
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("CLR MessageRunner "+Arrays.asList(args));
		
	}
}
