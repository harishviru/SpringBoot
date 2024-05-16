package com.har.journey.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.har.journey.repo.EmployeeRepository;

//#01 . By Using @Query annotation   (Supports Without OUT Param)

@Component
@Order(2)
public class ProcedureOneWithQueryAnnTestRunner implements CommandLineRunner {


	@Autowired
	private EmployeeRepository empRepo;
	
	@Override
	public void run(String... args) throws Exception {
		 System.out.println("___________________01. By Using @Query Annotation_____________________ ");
		
		empRepo.getAllEmps().forEach(System.out::println);
		System.out.println();
		
		empRepo.getEmpsByDept("QA").forEach(System.out::println);
		System.out.println();
		
	}

}
