package com.har.journey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SblScheduling12IApplication {

	public static void main(String[] args) {
		SpringApplication.run(SblScheduling12IApplication.class, args);
	}

}
/** #Scheduling using SpringBoot
    Executing a task in a loop over "PERIOD OF TIME" 
                                           (OR)
                                    "POINT OF TIME"
                                    
                                           
 *)PERIOD OF TIME  : It indicates time gap(any start date/time)
                  ex :
                       6Mins
                       24Hrs
                       4days
                       8Months
       
  *)POINT OF TIME  : It indicates  exact date/time for start
                  ex :
                      7AM
                      21st Sep 7AM
                      9AM 3rd Dec
                      7:50PM
 
 -----------------------------Steps to write scheduling in spring Boot----------------
#1. To active scheduling 
        @EnableScheduling   (on top of main class)
 
#2. Define one class with methods
        @Scheduled(-type-)          (on top of method)        

#3.Choose scheduling type
         i)fixedDelay         (Period of Time)
         ii)fixedRate         (Period of Time) 
         iii)cron expression   (Point of Time / Period of Time)

Note :
     i) 1000 Milli secs =1sec
     ii)Schedular method never takes any parameter and return nothing
       syntax :
           public void <name>(){
                     logic....
                     ....
                     }
               


*/
