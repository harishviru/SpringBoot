package com.har.journey.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.har.journey.model.Employee;
import com.har.journey.repo.EmployeeRepository;


@Component
@Order(1)
public class EmployeeDataDumpRunner implements CommandLineRunner {

	@Autowired
	private EmployeeRepository empRepo;
	
	@Override
	public void run(String... args) throws Exception {
		empRepo.save(new Employee(101, "Arjun", "QA", 3000.0));
		empRepo.save(new Employee(102, "Bhavani", "DEV", 5000.0));
		empRepo.save(new Employee(103, "Arun", "QA", 9000.0));
		empRepo.save(new Employee(104, "Vamsi", "DEV", 8000.0));
		empRepo.save(new Employee(105, "Niharika", "DEV", 4000.0));
		empRepo.save(new Employee(106, "sachin", "QA", 2000.0));
		empRepo.save(new Employee(107, "chandra", "BA", 1000.0));
		empRepo.save(new Employee(108, "Harish", "QA", 9700.0));
		
		System.out.println("----------------------DATA SAVED SUCCESSFULLY-----------------------");
		
	}

}
