package com.har.journey.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.har.journey.model.AlertSystem;

@Component
public class MyProfileDataInfoRunner implements CommandLineRunner {

	@Autowired
	private AlertSystem als;
	
	
	@Override
	public void run(String... args) throws Exception {
		als.sendMessage();
	}

}
