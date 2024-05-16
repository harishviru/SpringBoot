package com.har.journey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("emp")
public class Employee {

	
	@Value("123")
	private int empNo;
	@Value("Harish")
	private String eName;
	@Autowired  //It is used to Link/Wire Address class obj to Employee class obj
	private Address addrs;
	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", eName=" + eName + ", addrs=" + addrs + "]";
	}
	
}
