package com.har.journey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 *   Calling Procedure Using Spring Boot
 *      i)@Query         (Supports Without OUT Param)
 *      ii)JPA 2.x API   (EntityManagerFactory | EntityManager)
 * 
 */ 


@SpringBootApplication
public class SbvDataJpaStoredProcedure22Application {

	public static void main(String[] args) {
		SpringApplication.run(SbvDataJpaStoredProcedure22Application.class, args);
	}

}
