package com.har.journey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SbdRunners04Application {

	public static void main(String[] args) {
		SpringApplication.run(SbdRunners04Application.class, args);
	}

}

/**
 #CommandLineRunner/ApplicationRunner
   1)Write one public class
   2)Implements CommandLineRunner(I) (Or) ApplicationRunner(I)
   3)Override run(-) method
   4)Add @Component over the class 
   5)If multiple CLR or ALR found then It will executes based on Alphabets Order,
     if we want to control order we can use @Order annotation
     
     #@Order(value) annotation 
     value : least value as First ,highest value as Last execution
     

   ApplicationRunner->run(ApplicationArguments args):
       ApplicationArguments -> OptionArgs          --key=value (input)
                            ->NonOptionArgs        start  stop read  (commands)


*/