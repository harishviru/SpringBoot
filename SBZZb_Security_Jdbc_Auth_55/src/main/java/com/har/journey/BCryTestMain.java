package com.har.journey;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryTestMain {

	
	public static void main(String[] args) {
		BCryptPasswordEncoder bcry =new BCryptPasswordEncoder();
		System.out.println(bcry.encode("ram"));
	}
}
