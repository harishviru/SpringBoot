package com.har.journey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SbjProfilesYaml10IiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbjProfilesYaml10IiApplication.class, args);
	}

}
/** #Profiles using YAML
 * 
 * --------------Spring Boot 2.x-------------[2.3.4.RELEASE]
 * my:
 app:
  driver: DEFAULT-DRIVER
  url: DEFAULT-URL
  
---
spring:
  profiles: qa
 
my:
 app:
  driver: QA-DRIVER
  url: QA-URL  

---
spring:
  profiles: prod
  
my:
 app:
  driver: PROD-DRIVER
  url: PROD-URL    
 * 
 * 
 * 
 * 
 * 
 * -------------------- Spring Boot 3.x-------------------
 my:
 app:
  driver: DEFAULT-DRIVER
  url: DEFAULT-URL
  
---
spring:
  config:
    activate:
      on-profile: qa
 
my:
 app:
  driver: QA-DRIVER
  url: QA-URL  

---
spring:
  config:
    activate:
      on-profile: prod 
  
my:
 app:
  driver: PROD-DRIVER
  url: PROD-URL    
 * 
 * 
 * 
 */
