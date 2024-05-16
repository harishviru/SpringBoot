package com.har.journey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SBBAutoWire02Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SBBAutoWire02Application.class, args);
		Employee emp=ctx.getBean("emp",Employee.class);
		System.out.println(emp);
	}

}

/* This Application provides overview on @Autowired Annotation
 *  : //It is used to Link/Wire One(A) class obj to Another(B) class obj
**/
