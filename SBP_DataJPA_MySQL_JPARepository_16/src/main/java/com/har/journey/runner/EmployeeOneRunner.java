package com.har.journey.runner;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import com.har.journey.model.EmployeeOne;
import com.har.journey.repo.EmployeeOneRepository;

@Component
@Order(1)
public class EmployeeOneRunner implements CommandLineRunner{

	@Autowired
	private EmployeeOneRepository empRepo;
	
	@Override
	public void run(String... args) throws Exception {

		empRepo.saveAll(Arrays.asList(
				      new EmployeeOne(101, "RAM", "DEV"),
				      new EmployeeOne(102, "SAM", "QA"),
				      new EmployeeOne(103, "SYED", "HR"),
				      new EmployeeOne(104, "RAGHU", "BA"),
				      new EmployeeOne(105, "VIVEK", "DEV"),
				      new EmployeeOne(106, "GANGA", "QA"),
				      new EmployeeOne(107, "CHANDRA", "DEV"),
				      new EmployeeOne(108, "HARI", "BA"),
				      new EmployeeOne(109, "SRI", "QA"),
				      new EmployeeOne(110, "SUNDAR", "DEV")
				));
		
		System.out.println("----------------findAll(Example)-------------------------");
		//Example
		EmployeeOne emp =new EmployeeOne();
		emp.setDept("DEV");
		emp.setEmpName("RAM");                 //select * from emp_tabe e1_0 where e1_0.dept=? and e1_0.emp_name=?
		
		EmployeeOne empObj =new EmployeeOne();
		empObj.setDept("BA");                 //select * from emp_tabe e1_0 where e1_0.dept=? 
		
		
		
		Example<EmployeeOne> example =Example.of(empObj);
		
		empRepo.findAll(example).forEach(e->System.out.println(e));
		
		
	}

}
