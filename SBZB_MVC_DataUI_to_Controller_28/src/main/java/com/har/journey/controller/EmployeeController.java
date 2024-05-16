package com.har.journey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.har.journey.model.Employee;

//#02 Sending Data from UI to Controller (By Using  @ModelAttribute)

/**  Q) Difference between ModelAttribute and Model?
       A)    Model        : Send data from Controller to UI
            ModelAttribute : Send form data from UI to Controller

 */
@Controller
public class EmployeeController {

	// #1. Show Register Page
	@GetMapping("/register")
	public String showReg() {
		return "EmployeeReg";
	}
	
	
	// #2. Read Form Data
   //@RequestMapping(value="/add",method = RequestMethod.POST)
	@PostMapping("/add")
	public String readData(
			    //@ModelAttribute("employee")Employee  emp  // FC create Employee class obj name as : employee
			    @ModelAttribute Employee  employee,
			    Model model
			) {
		System.out.println("Employee :"+employee);
		model.addAttribute("employee", employee);
		return "EmpData";
	}
	
	
	
	
	
}
