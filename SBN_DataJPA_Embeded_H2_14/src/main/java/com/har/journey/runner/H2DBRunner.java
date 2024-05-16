package com.har.journey.runner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.har.journey.model.Employee;
import com.har.journey.repo.EmployeeRepository;


@Component
public class H2DBRunner implements CommandLineRunner {

	@Autowired
	private EmployeeRepository empRepo;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("empRepo            :"+empRepo.getClass().getName());
	  System.out.println("empRepo superclass :"+empRepo.getClass().getInterfaces());
	  
	  System.out.println("-----------------------save()------------------------");

	  // Insert operation
	  empRepo.save(new Employee(100,"AA",2000.0));   
	  empRepo.save(new Employee(101,"BB",4000.0));
	  empRepo.save(new Employee(102,"CC",7000.0));
	  empRepo.save(new Employee(null,"DD",8000.0));
	  
	  
	  
	  System.out.println("-----------------------findAll()------------------------");
	  
	 // Retrieve data
	  Iterable<Employee> empItr =empRepo.findAll();
	  for(Employee emp:empItr) {
            System.out.println(emp);		  
	  }
	  System.out.println();
	  //JDK 1.8 Lambda Expression
	  empRepo.findAll().forEach(emp->System.out.println(emp));
	  
	  System.out.println();
	  //JDK 1.8 Method Reference Expression
	  empRepo.findAll().forEach(System.out::println);
	  
	  
	  System.out.println("-----------------------findAllById()------------------------");
      //Iterable is Parent for all collection class
	 List<Employee> empList =(List<Employee>) empRepo.findAllById(Arrays.asList(1,2,5));
	 empList.forEach(emp->System.out.println(emp));
	  
	  
	  
	  System.out.println("-----------------------save()------------------------");

	  // save operation without Id (Here @GeneratedValue annotation will generate Id value)
	  Employee e= empRepo.save(new Employee("HH",100.0));
	  System.out.println(e);
	  
	  
	  System.out.println("-----------------------saveAll()------------------------");

	  //SaveAll
	  empRepo.saveAll(Arrays.asList(
			  new Employee("MM",200.0),
			  new Employee("NN",599.0)
			  ));
	  
	  
	  System.out.println("-----------------------findById(-)------------------------");
	  
	  //Read one row by using findById
	  Optional<Employee> optEmp =empRepo.findById(104);
	  if(optEmp.isPresent()) {
		  System.out.println(" Emp :"+optEmp.get());
	  }else {
		  System.out.println("EmpId with 104 not found");
	  }
	  
	  System.out.println("-----------------------count()------------------------");
	  long count =empRepo.count();
	  System.out.println("count :"+count);
	}
}
