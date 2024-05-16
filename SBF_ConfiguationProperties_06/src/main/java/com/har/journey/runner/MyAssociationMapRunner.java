package com.har.journey.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.har.journey.model.DBConnection;

//It is used to explain @ConfigurationProperties annotation :
                               //iv) Working with Association Mapping  [Has-A]

@Component
@ConfigurationProperties(prefix ="my.hasapp")
@Order(5)
public class MyAssociationMapRunner implements CommandLineRunner {

	private DBConnection con;
	
	
	@Override
	public void run(String... args) throws Exception {
	    System.out.println("-------@ConfigurationProperties Working with Association Mapping  [Has-A]--------------");
        System.out.println(this);
	}

	public void setCon(DBConnection con) {
		this.con = con;
	}
	public DBConnection getCon() {
		return con;
	}

	@Override
	public String toString() {
		return "MyAssociationMapRunner [con=" + con + "]";
	}	
}


