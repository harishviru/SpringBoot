package com.har.journey.runner;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.har.journey.model.Employee;
import com.har.journey.repo.EmployeeRepository;

@Component
public class EmployeeCollectionMappingRunner implements CommandLineRunner {

	@Autowired
	private EmployeeRepository empRepo;
	
	@Override
	public void run(String... args) throws Exception {

		empRepo.save(
				   new Employee(10,"Indu","QA",4500.0,
						       List.of("P1","P2"),
						       Set.of("T1","T2"),
						       Map.of(101,"M1",102,"M2"),
						       List.of("Lead","Dev","QA","BA")
				             )
				);
		
		
		  System.out.println("____________________Employee saved successfully________________________________");
	}

}
