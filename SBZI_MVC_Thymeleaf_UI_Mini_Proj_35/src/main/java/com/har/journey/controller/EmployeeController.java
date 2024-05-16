package com.har.journey.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.har.journey.model.Employee;
import com.har.journey.service.IEmployeeService;

@Controller
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	private IEmployeeService empService;
	
	//#01. Show Registeration Form
	@GetMapping("/register")
	public String showRegForm(Model model) {
		model.addAttribute("empObj", new Employee());
		return "EmpForm";
	}
	
	//#02. Save the emp in DB
	@PostMapping("/save")
	public String empSave(@ModelAttribute Employee empObj,Model model) {
		Long empId =empService.saveEmployee(empObj);
		model.addAttribute("empMsg", "Employee saved '"+empId+"' successfully");
		model.addAttribute("empObj", new Employee());
		return "EmpForm";
	}
	
	//#03. Display all records
	//@GetMapping("/all")
	public String displayAll(Model model) {
		List<Employee> empList = empService.getAllEmpList();
		model.addAttribute("empList", empList);
        return "EmpData";
	}
	
	//# Display all emp information with Pagination
	@GetMapping("/all")
	public String displayAllWithPagination(@PageableDefault(page = 0,size =3) Pageable pageable, Model model) {
		Page<Employee> empPage = empService.getAllEmpList(pageable);
		model.addAttribute("empList", empPage.getContent());
		model.addAttribute("page", empPage);
        return "EmpData";
	}
	
	
	//#04. Delete record by empId
	@GetMapping("/delete")
	public String deleteEmp(@RequestParam Long empId) {
		empService.deleteEmp(empId);
		return "redirect:all";
	}
	
	//#05. Show Edit/update Form
	@GetMapping("/edit")
	public String showEditForm(@RequestParam Long empId ,Model model) {
		    Employee employee=empService.getEmployeeId(empId);
			model.addAttribute("employeeInfo", employee);
			return "EmpEditForm";
	}
	
	//#06. Show Registeration Form
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee employeeInfo,@RequestParam Long empId) {
		  empService.updateEmp(employeeInfo,empId);
		  return "redirect:all";
	}
	
	
	
	
	
	//#08. Validate/Check Email Exist or Not
	@GetMapping("/checkEmail")
	public @ResponseBody String checkEmail(@RequestParam String email) {
		String message="";
		if(empService.isEmailExist(email)) {
			message =email+ " Already Exist";
		}
		return message;
	}
	
}
