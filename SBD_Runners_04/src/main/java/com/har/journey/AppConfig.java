package com.har.journey;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	  //#01 Anonymous Inner class
	  @Bean
	  public CommandLineRunner runA() {
		 return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				System.out.println("CLR From Anonymous Inner class"+Arrays.asList(args));
				
			}
		};
	   }
	
	   //#02 Lambda Expression
		@Bean
		public CommandLineRunner runB() {
			return (args) -> {
					System.out.println("CLR From Lambda Expression"+Arrays.asList(args));
					
				};
		}
		//#03 Method Reference
		@Bean
		public CommandLineRunner runC() {
			return AppConfig::test;
		}
	
	  public static void test(String...args) {
			System.out.println("CLR From Methdo Reference"+Arrays.asList(args));
	  }
		
}
