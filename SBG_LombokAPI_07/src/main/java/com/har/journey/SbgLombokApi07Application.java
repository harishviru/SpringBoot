package com.har.journey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@SpringBootApplication
public class SbgLombokApi07Application {

	public static void main(String[] args) {
		SpringApplication.run(SbgLombokApi07Application.class, args);
	}

}

/**
*  @NoArgsConstructor   
*                    0-param constructor
   @AllArgsConstructor   
                   All(3) param constructor
   @RequiredArgsConstructor 
             i)1-param (@NonNull consider/exists) constructor
             i)if @NonNull not found ,then 0-param constructor 
*
*
**
*/
