package com.har.journey.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.har.journey.model.Employee;
import com.har.journey.model.Model;
import com.har.journey.model.Product;
import com.har.journey.model.Vendor;

//Different types of Return Type as ResponseBody

@RestController
public class EmployeeController {

	
	//#01 . Return Type : String 
	@GetMapping("/a")
	public String showA() {
		return "Welcome to Spring Boot";
	}
	
	//#02 . Return Type : Employee 
	@GetMapping("/b")
	public Employee showB() {
		return new Employee(100l, "Harika", "harika@gmail.com", 3900.0);
	}
	
	//#03 (i). Return Type : List<String> 
	@GetMapping("/c")
	public List<String> showC() {
		return List.of("A","B","C","D");
	}
	
	//#03 (ii). Return Type : Set<String> 
	@GetMapping("/cc")
	public Set<String> showCC() {
		return Set.of("A","B","C","D");
	}
	
	//#04 . Return Type : List<Object>
	@GetMapping("/d")
	public List<Employee> showD() {
		return List.of(
				new Employee(100l, "Harika", "harika@gmail.com", 3900.0),
				new Employee(101l, "Vamsi", "vamsi@gmail.com", 8900.0),
				new Employee(102l, "Raghu", "raghu@gmail.com", 6500.0)
				);
	}
	
	
	
	
	//#05. Return Type : Map<K,V> 
	@GetMapping("/e")
	public Map<String,String> showE() {
		return Map.of("Telegana","Hyderbad","Tamilnadu","cheenai","Karnataka","Bengaluru");
	}
	
	//#06. Return Type : Map<String,Employee> 
	@GetMapping("/f")
	public Map<String, Employee> showF() {
		return Map.of(
				"Obj1",new Employee(100l, "Harika", "harika@gmail.com", 3900.0),
				"Obj2",new Employee(101l, "Vamsi", "vamsi@gmail.com", 8900.0),
				"Obj3",new Employee(102l, "Raghu", "raghu@gmail.com", 6500.0)
				);
	}
	
	//#06. HAS-A
	@GetMapping("/g")
	public Product showG() {
		return new Product(290, "PEN", 
				               new Model(800, "RED", 55.0, 
				            		   new Vendor(300, "TCS")
				            		   )
				               
				 );
				
	}
	
	
	
	
	
}

