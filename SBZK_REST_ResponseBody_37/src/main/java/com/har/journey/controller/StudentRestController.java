package com.har.journey.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.har.journey.model.Employee;

@RestController
public class StudentRestController {

	
	   /**  ResponseEntity is a standard (= Status + Header + Body). Here we can provide
             specific Status for client machine and any header if they want.

             If we use Direct DataType like String , it indicates only Body. On success,
             default status is taken as 200/OK, No specific header added.
	
	    */
	    //#01 . Return Type : String 
		@GetMapping("/sa")
		public String showA() {
			return "WELCOME TO SPRING BOOT";
		}
		
		//#02 . Return Type :   ResponseEntity<String>
		@GetMapping("/sb")
		public ResponseEntity<String> showB() {
			return new ResponseEntity<String>("WELCOME TO ResponseEntity", HttpStatus.OK);
		}
		
		
		//-----------Accept -------
		/**  ----------------POSTMAN---------------------------
                      GET  http://localhost:8080/b      SEND
                       Header
                     [Accept]      [application/xml]
             -------------------------------------------------
		 * 
		 * 
		 * 
		 * @return
		 */
		//#03 . Return Type : Employee 
		@GetMapping("/sc")
		public Employee showC() {
			return new Employee(9002l, "Harish", "harish@gmail.com", 3900.0);
		}
		
		
		
		
		
		
	
}
