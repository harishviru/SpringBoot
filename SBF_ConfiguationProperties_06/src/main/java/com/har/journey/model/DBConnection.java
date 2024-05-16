package com.har.journey.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class DBConnection {

	private String driver;
	private String url;
	private String username;
	private String password;
	
	private List<Integer> marks;
	
	
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
	
	public void setMarks(List<Integer> marks) {
		this.marks = marks;
	}
	public List<Integer> getMarks() {
		return marks;
	}
	@Override
	public String toString() {
		return "DBConnection [driver=" + driver + ", url=" + url + ", username=" + username + ", password=" + password
				+ ", marks=" + marks + "]";
	}

}
