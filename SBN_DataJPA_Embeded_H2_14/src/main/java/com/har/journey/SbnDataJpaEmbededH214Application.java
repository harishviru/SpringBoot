package com.har.journey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**This application works on basic crud operations (CrudRepository)
 *         +
 *         Embeded Database
 *
 */

@SpringBootApplication
public class SbnDataJpaEmbededH214Application {

	public static void main(String[] args) {
		SpringApplication.run(SbnDataJpaEmbededH214Application.class, args);
	}

}

/**
--------------------H2 Database------------------- 
#To View H2 Database inside browser
spring.h2.console.enabled=true

#To view runtime generated Database name and to generate provide name as Database name
spring.datasource.url=jdbc:h2:mem:testdb

 * 
 */
