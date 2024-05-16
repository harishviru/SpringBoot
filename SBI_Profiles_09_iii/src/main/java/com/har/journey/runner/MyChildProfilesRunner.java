package com.har.journey.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties(prefix = "my.app")
@Data
public class MyChildProfilesRunner implements CommandLineRunner {

	private String title;
	private String ver;
	private String driver;
	private String url;
	private String host;
	private String port;
	
	
	@Override
	public void run(String... args) throws Exception {
       System.out.println(this);
	}

}
