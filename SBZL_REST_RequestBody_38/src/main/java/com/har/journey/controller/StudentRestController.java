package com.har.journey.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.har.journey.model.Student;

@RestController
@RequestMapping("/stud")
public class StudentRestController {
	
	
	//#01 .  @RequestBody is used to convert JSON to Object (Serialization)
	@PostMapping("/save")
	public String saveStudentData(@RequestBody Student student) {
		return "DATA IS SAVED : "+student;
	}
	
	
	//#02 . Here we are accessing HttpHeaders by using @RequestHeader Annotation
	@PostMapping("/save1")
	public String saveStudentData1(@RequestBody Student student,@RequestHeader HttpHeaders headers) {
		// Accessing all headers
        headers.forEach((key, value) -> {
            System.out.println(key + ": " + value);
        });

        // Or you can access a specific header by its name
        String contentType = headers.getFirst(HttpHeaders.CONTENT_TYPE);
        System.out.println("Content-Type: " + contentType);
		
		return "DATA IS SAVED : "+student;
	}
	

	// #03. If we want to control 'INPUT' OR 'Content-Type' then we can consumes attribute in @XXXMapping Annotation  
	// It accept/consumes only only JSON
	@PostMapping(value="/save2",consumes = {MediaType.APPLICATION_JSON_VALUE})
	public String saveStudentData2(@RequestBody Student student) {
		return "DATA IS SAVED : "+student;
	}
	
	
	// #04. If we want to control 'OUTPUT' OR 'Content-Type' then we can produces attribute in @XXXMapping Annotation  
	// It will return/produces only TEXT/String
	@PostMapping(value="/save3",produces = {MediaType.TEXT_PLAIN_VALUE})
	public String saveStudentData3(@RequestBody Student student) {
		return "DATA IS SAVED : "+student;
	}
	
	
	
}
