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
	public String showForm(Model model) {
		Employee emp=new Employee();
		model.addAttribute("employee", emp);
		return "EmpReg";
	}
	
	@PostMapping("/save")
	public String readFormData(@ModelAttribute Employee employee,Model model) {
		System.out.println(" emp : "+employee);
		model.addAttribute("emp", employee);
		return "EmpData";
	}
	
	
	
	
	
}
