package com.har.journey.runner;

import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//It is used to explain @ConfigurationProperties annotation :
                                    //iii) Working with Map/Properties  [2D Collection]

@Component
@ConfigurationProperties(prefix ="my.result")
@Order(4)
public class MyPropsMapRunner implements CommandLineRunner {

	private Map<String,Integer> edata;
  //private Properties edata;     //Properties internally treats as key -String ,Value-String
	
	@Override
	public void run(String... args) throws Exception {
		    System.out.println("-------@ConfigurationProperties #Working with Map/Properties  [2D Collection]--------------");
	        System.out.println(this);
	}

	public Map<String, Integer> getEdata() {
		return edata;
	}
	public void setEdata(Map<String, Integer> edata) {
		this.edata = edata;
	}

	@Override
	public String toString() {
		return "MyPropsMapRunner [edata=" + edata + "]";
	}

}
