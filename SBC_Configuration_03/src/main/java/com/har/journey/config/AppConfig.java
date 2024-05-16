package com.har.journey.config;

import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.har.journey.DBExport;

@Configuration  //It is used make class as Configuration class/file.
public class AppConfig {

	//#01. Create Predefined class Object by using @Bean
	 @Bean
	 public Date dt() {
		 return new Date();
	 }
	
	//#02. Create User defined class Object by using @Bean
	 @Bean
	 public DBExport dbExp() {
		 DBExport dbexp =new DBExport();
		 dbexp.setTableName("Employee");
		 dbexp.setData("EmpNo   EmpName Designation  \n  129  Harish SeniorEngineer");
		 return dbexp;
	 }
	
}
