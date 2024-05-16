package com.har.journey.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.har.journey.model.Employee;

@Controller
public class EmployeeController {

	
	//-------------- Redirect --------------------
	
	@GetMapping("/show")
	public String show() {
		System.out.println("*************FROM SHOW*************");
	  //return "redirect:/showa";  // redirect to 
		return "redirect:showa"; 
	}
	
	
	@GetMapping("/showa")
	public String showA() {
		System.out.println("*************FROM SHOWA*************");
		return "Home";
	}
	
	
	//-----------------------@PathVariable-----------------------------
	// syntax     : {pathVariableName}  > @PathVariable(value = "pathVariableName") Datatype localVarName
	// If Path Varible name and in annotation value or localVariableName must match .  org.springframework.web.bind.MissingPathVariableException: Required URI template variable 'empName1' for method parameter type String is not present
	//> default true
	
	
	@GetMapping("/showb/{empName}")
	public String showB(@PathVariable String empName) {
		 System.out.println("*************FROM SHOWB*************" +empName);
		return "Home";
	}
	
	@GetMapping("/showc/{empName}")
	public String showC(@PathVariable(value = "empName") String name) {
		System.out.println("*************FROM SHOWC*************" +name);
		return "Home";
	}
	
	
	//  http://localhost:9090/showd/abc/api/123  Here empName : abc , id=123
	@GetMapping("/showd/{empName}/api/{id}")
	public String showD(@PathVariable(value = "empName") String name ,@PathVariable Integer id) {
		System.out.println("*************FROM SHOWD*************" +name +"  "+id);
		return "Home";
	}
	
	
	// http://localhost:9090/showe/api/abc   :  name =abc
	@GetMapping(value={"/showe/api","/showe/api/{empName}"})
	public String showE(@PathVariable(value = "empName",required = false) String name ) {
		System.out.println("*************FROM SHOWE*************" +name);
		return "Home";
	}
	
	@GetMapping(value="/showf/{apiVersion}/{empName}")
	public String showF(@PathVariable Map<String, String> pathVarsMap) {
		System.out.println("*************FROM SHOWF*************" +pathVarsMap);
		return "Home";
	}
	
	
	//--------------------------ModelAndView ,ModelMap-----------------
	
	//ModelAndView
	@GetMapping(value="/showg/abcd")
	public ModelAndView showG() {
		System.out.println("*************FROM SHOWG*************");
		
		ModelAndView modelandView =new ModelAndView();
		modelandView.setViewName("Home1");        // viewName
		modelandView.addObject("emp", "Harish");  // Model object      
		return modelandView;
	}
	
	//ModelMap
	@GetMapping(value="/showi")
	public String showI(ModelMap modelMap) {
		System.out.println("*************FROM SHOWI*************");
		modelMap.addAttribute("emp", "Harish");   
		return "Home1";
	}
	
	
	
	//--------------------------File Upload-----------------
	@GetMapping(value="/showForm")
	public String showForm() {
		System.out.println("*************FROM showForm*************");
		return "FileUploadForm";
	}
	
	@PostMapping(value="/upload")
	public String upload(MultipartFile file) {
		System.out.println("*************FROM upload*************"+file.getOriginalFilename() +" :" +file.getSize());
		return "Home";
	}
	
	
	@GetMapping(value="/showEmpForm")
	public String showEmpForm() {
		System.out.println("*************FROM showEmpForm*************");
		return "EmpForm";
	}
	@PostMapping(value="/empUpload")
	public String empUpload(@ModelAttribute Employee employee ,MultipartFile empResume) {
		System.out.println("employee :"+employee);
		System.out.println("*************FROM empUpload*************"+empResume.getOriginalFilename() +" :" +empResume.getSize());
		return "Home";
	}
	
	
	
	
	
	
	
}
