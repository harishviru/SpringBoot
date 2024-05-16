package com.har.journey.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.har.journey.util.EmailUtil;

@Component
public class EmailTestRunner implements CommandLineRunner{

	@Autowired
	private EmailUtil emailUtil;
	
	@Value("${email.from}")
	private String from;
	
	@Override
	public void run(String... args) throws Exception {
		Resource file =new ClassPathResource("application.properties");
		
		boolean resultFlag = emailUtil.sendMail(
				              from, 
				              new String[] { "javabyharishviru@gmail.com" },
				              new String[] { "sharish489@gmail.com" }, 
				              "Hello Java Mail API",
				              "Hi Welcome to test Mail", 
				              file);
		
		if(resultFlag) {
			System.out.println("SUCCESS");
		}else {
			System.out.println("FAILED");
		}
		
	}
}
