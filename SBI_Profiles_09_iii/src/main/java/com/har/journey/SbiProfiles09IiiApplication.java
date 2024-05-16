package com.har.journey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SbiProfiles09IiiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbiProfiles09IiiApplication.class, args);
	}

}

/**
 *  #Child Profiles (Useful for readability /modularity)
 *  
 *  
           #Include child profiles here  (In Spring 2.x)
           spring.profiles.include=proddb,prodemail
           
           #Include child profiles here  (In Spring 3.x)
            https://github.com/spring-projects/spring-boot/issues/24172

*/