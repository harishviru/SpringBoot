package com.har.journey.runner;

import java.util.List;
import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.har.journey.model.Vendor;

import lombok.Data;

@Component
@ConfigurationProperties(prefix ="my.app")
@Data
public class MyPropsYamlRunner implements CommandLineRunner {

	//# Primitives
	private Integer pid;
	private String pcode;
	private Double pcost;
	
	//1D Collection [List/Set/Array]
	 private List<String> colors;
	 //2D Collection [Map/Properties]
	 private Map<String,Integer> marks;
	
	 //Has-A
	 private Vendor ven;
	
	
	@Override
	public void run(String... args) throws Exception {
    System.out.println(this); 
		
	}

}
