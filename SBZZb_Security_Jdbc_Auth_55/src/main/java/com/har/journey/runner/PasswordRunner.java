package com.har.journey.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordRunner implements CommandLineRunner {

	@Autowired
	private JdbcTemplate jt;
	
	@Autowired
	private BCryptPasswordEncoder pwdEncoder;
	
	@Override
	public void run(String... args) throws Exception {
		
		jt.update("INSERT INTO user_tab (username,password,`role`,enabled) VALUES(?,?,?,?)", "ram",pwdEncoder.encode("ram"),"ADMIN",true);
		jt.update("INSERT INTO user_tab (username,password,`role`,enabled) VALUES(?,?,?,?)", "siva",pwdEncoder.encode("siva"),"EMPLOYEE",true);
		jt.update("INSERT INTO user_tab (username,password,`role`,enabled) VALUES(?,?,?,?)", "jai",pwdEncoder.encode("jai"),"STUDENT",true);
		
	}
}
