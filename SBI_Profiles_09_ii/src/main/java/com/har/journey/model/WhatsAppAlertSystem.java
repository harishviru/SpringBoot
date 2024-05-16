package com.har.journey.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties(prefix ="my.app")
@Data
@Profile("whatsapp")
public class WhatsAppAlertSystem implements AlertSystem {


	private String service;
	private String fmt;
	
	@Override
	public void sendMessage() {
     System.out.println("------------WhatsAPP Alert system--------------- "+service +" -  "+fmt);
     
	}


}
