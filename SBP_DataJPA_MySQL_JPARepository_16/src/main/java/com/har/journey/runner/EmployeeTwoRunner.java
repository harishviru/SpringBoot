package com.har.journey.runner;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.har.journey.model.EmployeeTwo;
import com.har.journey.repo.EmployeeTwoRepository;

@Component
@Order(2)
public class EmployeeTwoRunner implements CommandLineRunner{

	@Autowired
	private EmployeeTwoRepository empRepo;
	
	@Override
	public void run(String... args) throws Exception {

       Date date=new Date(System.currentTimeMillis());
		
		EmployeeTwo emp =new EmployeeTwo(2010,"Anusha","DEV",date,date,date,date);
		empRepo.save(emp);
		
		
	}

}
