package com.har.journey.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//#02
@RestController
public class StudentRestController {

	
	/**
	 *   -----------Request URLs-------------------------------
               
               http://localhost:8080/remove/abc     : DYNAMIC PATH  code :abc
               http://localhost:8080/remove/code    :STATIC PATH 
               http://localhost:8080/remove/{code}  : DYNAMIC PATH  code :{code}
               http://localhost:8080/remove/Code    : DYNAMIC PATH  code :Code
	 * @return
	 */
	
	
	@GetMapping("/remove/code")
	public String removeA() {
		return "STATIC PATH ";
	}
	
	@GetMapping("/remove/{code}")
	public String removeB(@PathVariable String code) {
		return "DYNAMIC PATH  code :"+code;
	}
	
	
}
