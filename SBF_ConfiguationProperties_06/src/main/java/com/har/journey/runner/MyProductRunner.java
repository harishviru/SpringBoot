package com.har.journey.runner;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//It is used to explain @ConfigurationProperties annotation :
                                //ii) Working with List/Set/Array  [1D Collection]

@Component
@ConfigurationProperties(prefix ="my.app")
@Order(3)
public class MyProductRunner implements CommandLineRunner {

	  private List<String> colors;
    //private Set<String> colors;
	//private String[] colors;
	
	
	@Override
	public void run(String... args) throws Exception {
		    System.out.println("-------@ConfigurationProperties #Working with List/Set/Array  [1D Collection]--------------");
	        System.out.println(this);
	}
	
	public void setColors(List<String> colors) {
		this.colors = colors;
	}
	public List<String> getColors() {
		return colors;
	}

	@Override
	public String toString() {
		return "MyProductRunner [colors=" + colors + "]";
	}
}
