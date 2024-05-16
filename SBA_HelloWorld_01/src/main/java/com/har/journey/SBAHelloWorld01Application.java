package com.har.journey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SBAHelloWorld01Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SBAHelloWorld01Application.class, args);
		WishMessage wMsg =ctx.getBean("wishMessage",WishMessage.class);
		wMsg.WishMsg("Harish");
	}

}
