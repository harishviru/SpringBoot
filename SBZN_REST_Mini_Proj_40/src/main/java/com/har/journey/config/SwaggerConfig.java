package com.har.journey.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	Docket showDocket() {
		return new Docket(DocumentationType.SWAGGER_2) // Create a EMPTY Docket
				.select() // select
				.apis(RequestHandlerSelectors.basePackage("com.har.journey.controller")) // from basePackage
				.paths(PathSelectors.regex("/api.*")) // where common path
				.build() // Build the final Docket object
				.apiInfo(getApiInfo());
	}

	public ApiInfo getApiInfo() {
		return new ApiInfo("Product-API", "Product Service", "1.2",
				"https://github.com/harishviru/SpringBootMicroservices",
				new Contact("Harish", "https://github.com/harishviru/SpringBootMicroservices", "sharish489@gmail.com"),
				"SB License", 
				"https://github.com/harishviru/SpringBootMicroservices",
				Collections.emptyList());
	}

}
