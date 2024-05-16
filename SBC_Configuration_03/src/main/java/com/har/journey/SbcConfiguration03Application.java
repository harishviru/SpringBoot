package com.har.journey;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SbcConfiguration03Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SbcConfiguration03Application.class, args);
		Date date =ctx.getBean("dt",Date.class); //Predefined
		System.out.println("date :"+date);
		System.out.println("-------------------------------------");
		
		DBExport dbExp =ctx.getBean("dbExp",DBExport.class); //User Defined
		System.out.println(dbExp);
	}

}

/*
* @Configuration  //It is used make class as Configuration class/file.
* 
*      @Bean
*      #01. Create Predefined class Object by using @Bean
	   #02. Create User defined class Object by using @Bean
*/