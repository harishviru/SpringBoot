package com.har.journey.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties(prefix ="my.app")
@Data
@Profile("default")
public class SMSAlertSystem implements AlertSystem {

	private String service;
	private String fmt;
	
	@Override
	public void sendMessage() {
     System.out.println("------------SMS Alert system--------------- "+service +" -  "+fmt);
     
	}

}
