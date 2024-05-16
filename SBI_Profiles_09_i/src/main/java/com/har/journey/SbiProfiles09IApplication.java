package com.har.journey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SbiProfiles09IApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbiProfiles09IApplication.class, args);
	}

}
/*#Profiles Concept  : 
              if any reading key is not present then it will check default(application.properties) profile 

  syntax (To maintain properties): 
  --------------------------------
                application-<ProfileName>.properties
                
              Ex : application-qa.properties
              Here above file belongs to qa profile
              
  syntax (To activate profile at runtime): 
  ---------------------------------------
                --spring.profiles.active=<ProfileName>
    
            Ex: --spring.profiles.active=prod
   
 */
