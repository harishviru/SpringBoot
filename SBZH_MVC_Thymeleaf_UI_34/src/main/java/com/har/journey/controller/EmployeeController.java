package com.har.journey.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.har.journey.model.Employee;

@Controller
@RequestMapping("/emp")
public class EmployeeController {

	
	
	@GetMapping("/show")
	public String showData(Model model) {
		
		//------Primitive Type
		model.addAttribute("id", 10);
		model.addAttribute("name", "NiHarika");
		model.addAttribute("rating", 8.3);
		model.addAttribute("loggedIn", true);
		model.addAttribute("role", "MGR");

		//-----------Object
		Employee emp =new Employee(901l, "Harish", 9000.0, "DEV");
		model.addAttribute("empObj", emp);
		
		//-----------Collection Type
		List<Employee> empList = List.of(
				new Employee(902l, "Vamsi", 8300.0, "DEV"),
				new Employee(903l, "Raghu", 6500.0, "QA"),
				new Employee(904l, "Nakshatra", 6200.0, "DEV"),
				new Employee(905l, "SriDevi", 7400.0, "BA"),
				new Employee(906l, "Ramu", 7800.0, "DEV"),
				new Employee(907l, "kalyan", 9800.0, "QA")
				);
		model.addAttribute("empList", empList);
		return "EmpData";
	}
	
	@GetMapping("/register")
	public String showForm(Model model) {
		model.addAttribute("employeeObj", new Employee());
		return "EmpForm";
	}
	
	
	
	@PostMapping("/save")
	public String empSave(@ModelAttribute Employee employeeObj,Model model) {
		employeeObj.setEmpId(1000l);
		model.addAttribute("employeeInfo", employeeObj);
		return "EmpInfo";
	}
	
	
	
	
	
	
}
