package com.har.journey.runner;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(80)
public class DBCurdOpsRunner implements CommandLineRunner{
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("CLR DBCurdOpsRunner :"+Arrays.asList(args));
		
	}
}
