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
import org.springframework.web.bind.annotation.RequestParam;

import com.har.journey.model.Employee;
import com.har.journey.service.IEmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private IEmployeeService empService;
	
	
	// #01. Show Register Form
	@GetMapping("/register")
	public String showEmpForm() {
		return "EmpForm";
	}
	
	// #02. Upload (Read Form Data)
	@PostMapping("/save")
	public String empSave(@ModelAttribute Employee employee,Model model) {
		Long dbEmpId =empService.saveEmployee(employee);
		model.addAttribute("msg", "Employee saved with '"+dbEmpId+"' successfully.");
		return "EmpForm";
	}
	
	
	//#03. Display all emp information
	//@GetMapping("/all")
	public String displayEmpList(Model model) {
		List<Employee> empList =empService.getAllEmpList();
		model.addAttribute("empList", empList);
		return "EmpData";
	}
	//#03. Display all emp information with Pagination
	@GetMapping("/all")
	public String displayEmpListWithPagination(@PageableDefault(page=0,size= 3) Pageable  pageable, Model model) {
		Page<Employee> empPage =empService.getAllEmpList(pageable);
		model.addAttribute("empList", empPage.getContent());
		model.addAttribute("page", empPage);
		return "EmpData";
	}
	
	//#04. Delete record based on employee Id
	@GetMapping("/delete")
	public String deleteEmp(@RequestParam Long empId) {
		empService.deleteEmp(empId);
		return "redirect:all";
	}
	
	
	//#05. Show Edit/update Form based on employee Id
	@GetMapping("/edit")
	public String showUpdateForm(Model model,@RequestParam Long empId) {
		Employee empObj =empService.getEmployeeId(empId);
		model.addAttribute("employeeObj", empObj);
		return "EmpUpdateForm";
	}
	
	//#06. Update Employee based on employee Id
	@PostMapping("/update")
	public String update(@ModelAttribute Employee employeeObj ,@RequestParam Long empId) {
		empService.updateEmp(employeeObj, empId);
		return "redirect:all";
	}
	
	
	
}
