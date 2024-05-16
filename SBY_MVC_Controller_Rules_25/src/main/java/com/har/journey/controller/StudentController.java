package com.har.journey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudentController {

	
	//@RequestMapping(value="/show",method = RequestMethod.GET)
	@RequestMapping("/show")
	public String showA() {
		return "Home";
	}
}
