package com.har.journey.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties(prefix = "my.app")
@Data
public class MyDataRunner implements CommandLineRunner {

	private Integer pid;
	private String pname;
	private Double pcost;
	
	@Override
	public void run(String... args) throws Exception {
     System.out.println(this);
	}

}
