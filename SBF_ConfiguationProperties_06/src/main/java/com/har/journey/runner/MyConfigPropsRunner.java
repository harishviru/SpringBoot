package com.har.journey.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//It is used to explain @ConfigurationProperties annotation :
                         //i) Working with Primitives

@ConfigurationProperties(prefix ="myapp.db")
@Component
@Order(2)
public class MyConfigPropsRunner implements CommandLineRunner {

	private String driver;
	private String url;
	private String username;
	private String password;
	private Double version;
	
	
	
	@Override
	public void run(String... args) throws Exception {
        System.out.println("-------@ConfigurationProperties #Working with Primitives--------------");
        System.out.println(this);
	}



	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Double getVersion() {
		return version;
	}

	public void setVersion(Double version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "MyConfigPropsRunner [driver=" + driver + ", url=" + url + ", username=" + username + ", password="
				+ password + ", version=" + version + "]";
	}

}
