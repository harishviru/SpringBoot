package com.har.journey.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.har.journey.model.Department;
import com.har.journey.model.Employee;
import com.har.journey.repo.DepartmentRepository;
import com.har.journey.repo.EmployeeRepository;
/*  ManyToOne (multiplicity)
    Employee ----<>Department
  */
@Component
@Order(1)
public class AssociationMappingMany_To_OneTestRunner implements CommandLineRunner {

	@Autowired
	private DepartmentRepository dRepo;
	
	@Autowired
	private EmployeeRepository eRepo;
	
	
	@Override
	public void run(String... args) throws Exception {

		Department d1= new Department(101, "DEV");
		Department d2= new Department(102, "QA");
		
		Employee e1 = new Employee(2001, "A", d1); 
		Employee e2 = new Employee(2002, "B", d1); 
		Employee e3 = new Employee(2003, "C", d2); 
		Employee e4 = new Employee(2004, "D", d2); 
		
		//Child class
		dRepo.save(d1);
		dRepo.save(d2);
		
		//Parent class
		eRepo.save(e1);
		eRepo.save(e2);
		eRepo.save(e3);
		eRepo.save(e4);
		
		System.out.println("__________________(MANY_TO_ONE)________SUCCESSFULLY INSERTED____________________________");
		
	}
}
