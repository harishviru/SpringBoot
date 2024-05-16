package com.har.journey.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//#03
@RestController               
public class EmployeeRestController {

	
	// URL :   http://localhost:8080/delete/MNO
	// Result >
	/**
	 *    "Ambiguous handler methods mapped for '/delete/MNO': 
           {public java.lang.String com.har.journey.controller.EmployeeRestController.removeDataB(java.lang.String),
           public java.lang.String com.har.journey.controller.EmployeeRestController.removeDataA(java.lang.Integer)}","path": "/delete/MNO"
	 * 
	 */
	@GetMapping("/delete/{id}")
	public String removeDataA(@PathVariable Integer id) {
		return "FROM A  ";
		
	}
	@GetMapping("/delete/{code}")
	public String removeDataB(@PathVariable String code) {
		return "FROM B  ";
	}
}
