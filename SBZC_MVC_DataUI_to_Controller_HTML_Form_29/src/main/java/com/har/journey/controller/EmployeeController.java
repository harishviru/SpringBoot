package com.har.journey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.har.journey.model.Employee;

@Controller
public class EmployeeController {

	// #01. Show Form 
	@GetMapping("/show")
	public String showForm() {
		return "EmpReg";
	}
	
	@PostMapping("/save")
	public String readFormData(@ModelAttribute("employee") Employee emp,Model model) {
		System.out.println(" emp : "+emp);
		model.addAttribute("emp", emp);
		return "EmpData";
	}
	
	
	
	
	
}
