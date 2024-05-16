package com.har.journey.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.har.journey.model.Employee;
import com.har.journey.model.Project;
import com.har.journey.repo.EmployeeRepository;
import com.har.journey.repo.ProjectRepository;

@Component
@Order(1)
public class DataInsertTestRunner implements CommandLineRunner {

	@Autowired
	private ProjectRepository pRepo;
	@Autowired
	private EmployeeRepository eRepo;
	
	@Override
	public void run(String... args) throws Exception {

		Project p1 =new Project(55, "P1", 5000.0, "TCS");
		Project p2 =new Project(56, "P2", 7000.0, "HCL");
		Project p3 =new Project(57, "P3", 8200.0, "BRILLIO");
		Project p4 =new Project(58, "P4", 4000.0, "WIPRO");
		Project p5 =new Project(59, "P5", 6300.0, "TCS");
		
		pRepo.save(p1);
		pRepo.save(p2);
		pRepo.save(p3);
		pRepo.save(p4);
		pRepo.save(p5);
		
		
		Employee e1=new Employee(10, "A", 3.3, "HYD", null);
		Employee e2=new Employee(11, "B", 3.4, "CHN", null);
		Employee e3=new Employee(12, "C", 4.6, "BAN", List.of(p2));
		Employee e4=new Employee(13, "D", 5.8, "HYD", null);
		Employee e5=new Employee(14, "E", 6.8, "VZG",  List.of(p3));
		
		
		eRepo.save(e1);
		eRepo.save(e2);
		eRepo.save(e3);
		eRepo.save(e4);
		eRepo.save(e5);
		
		System.out.println("_________________________DATA INSERTED SUCCESSFULLY______________________");
	}

}
