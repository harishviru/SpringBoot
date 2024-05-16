package com.har.journey.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.har.journey.repo.EmployeeRepository;
import com.har.journey.repo.ProjectRepository;

@Component
@Order(2)
public class JoinsTestRunner implements CommandLineRunner {

	@Autowired
	private ProjectRepository pRepo;
	@Autowired
	private EmployeeRepository eRepo;
	
	@Override
	public void run(String... args) throws Exception {

		
		eRepo.findDataByCode("P2").stream().map(obj->obj[0] +" - "+obj[1] +" - "+obj[2]).forEach(System.out::println);
		System.out.println();
		
		eRepo.findDataByClientRJ("BRILLIO").stream().map(obj->obj[0] +" - "+obj[1] +" - "+obj[2]).forEach(System.out::println);
		System.out.println();
		
		
		eRepo.findDataByAddrs("HYD").stream().map(obj->obj[0] +" - "+obj[1] +" - "+obj[2]).forEach(System.out::println);
		System.out.println();
		
		
		
	}

}
