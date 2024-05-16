package com.har.journey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

	//@RequestMapping(value="/home" ,method = RequestMethod.GET)
	@GetMapping("/home")
	public String showHome() {
		return "Home";
	}
	
	//@RequestMapping(value="/add" ,method = RequestMethod.POST)
	@PostMapping("/add")
	public String showData() {
		return "Data";
	}
	
	
	
	
}
