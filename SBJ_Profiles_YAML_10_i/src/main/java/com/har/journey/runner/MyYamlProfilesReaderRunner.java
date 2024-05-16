package com.har.journey.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
@ConfigurationProperties(prefix ="my.app")
public class MyYamlProfilesReaderRunner implements CommandLineRunner {

	private String driver;
	private String url;
	
	
	@Override
	public void run(String... args) throws Exception {
      System.out.println(this);
	}

}
