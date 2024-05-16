package com.har.journey.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.har.journey.model.Employee;
import com.har.journey.repo.EmployeeRepository;

@Component
public class MongoBasicOpsRunner implements CommandLineRunner {

	@Autowired
	private EmployeeRepository  empRepo;
	
	@Override
	public void run(String... args) throws Exception {
		// Save Operations /Update
		Employee emp1=new Employee("TWO", "DEV", 8000.0);
		Employee empdb= empRepo.save(emp1);
		System.out.println(" empdb :"+empdb);

		//ReadAll ->findAll
		empRepo.findAll().forEach(System.out::println);
		
		//findOne
		empRepo.findById("6631be458027bd090522442f").stream().forEach(System.out::println);

		//delete 
		empRepo.deleteById("6631bd1daaac557ea8d59761");
		
		//ReadAll ->findAll
		empRepo.findAll().forEach(System.out::println);
				
	}


}
