package com.har.journey.runner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//It is used to explain @Value annotation

@Component
@Order(1)
public class MyPropsRunner implements CommandLineRunner {

	@Value("${app-id}")
	private int appId;
	@Value("${title}")
	private String appName;
	@Value("${description}")
	private String descrip;
	@Value("${isMailExist}")
	private boolean isMailExist;
	@Value("${appChar}")
	private char appChar;
	
	@Override
	public void run(String... args) throws Exception {
        System.out.println("-------@Value--------------");
        System.out.println(this);
	}

	@Override
	public String toString() {
		return "MyPropsRunner [appId=" + appId + ", appName=" + appName + ", descrip=" + descrip + ", isMailExist="
				+ isMailExist + ", appChar=" + appChar + "]";
	}

	

}
