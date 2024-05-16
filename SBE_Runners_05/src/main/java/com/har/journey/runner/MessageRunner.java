package com.har.journey.runner;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MessageRunner implements ApplicationRunner{

	@Value("${emp.Name}")
	private String empName; //First It will load from Properties file 
	                        //next It will load from command prompt if it found same key it will override
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
     System.out.println("ALR");
     System.out.println("ALL                 :"+Arrays.asList(args.getSourceArgs()));
     System.out.println("NonOptionArgs       :"+args.getNonOptionArgs());
     System.out.println("OptionArgs port key :"+args.getOptionValues("port"));
     System.out.println("OptionArgs loc key  :"+args.getOptionValues("loc"));
     System.out.println("OptionArgs          :"+args.getOptionNames());
     System.out.println("empName :"+empName);
     
		
	}

}
