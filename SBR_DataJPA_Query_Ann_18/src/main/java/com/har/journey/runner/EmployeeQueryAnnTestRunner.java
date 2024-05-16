package com.har.journey.runner;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.har.journey.model.Employee;
import com.har.journey.repo.EmployeeRepository;


@Component
@Order(2)
public class EmployeeQueryAnnTestRunner implements CommandLineRunner {

	@Autowired
	private EmployeeRepository empRepo;
	
	@Override
	public void run(String... args) throws Exception {
	
		System.out.println("---------------------@Query Basic operations with Postional,Named Paramters  --------------------------");

		
		System.out.println("-------#01--------");
		empRepo.getAllEmps().forEach(System.out::println);
		System.out.println();
		
		System.out.println("-------#02--------");
		empRepo.getAllEmpsByDeptName("QA").forEach(System.out::println);
		System.out.println();
		
		System.out.println("-------#03--------");
		empRepo.getAllEmpsBetweenIds(103,109).forEach(System.out::println);
		System.out.println();
		
		System.out.println("-------#04--------");
		empRepo.getAllEmpsByIdIn(Arrays.asList(104,107,106,103)).forEach(System.out::println);
		System.out.println();
		
		
		System.out.println("-------#05--------");
		empRepo.getAllEmpInfoByDeptName("DEV").forEach(System.out::println);
		System.out.println();
		
		System.out.println("---------------------PROJECTION (Multiple Rows)--------------------------");
		
		System.out.println("-------#06--------");
		empRepo.getAllEmpsList().forEach(System.out::println);
		System.out.println();
		
		System.out.println("-------#07--------");
		empRepo.getAllEmpsList_OneCol().forEach(System.out::println);
		System.out.println();
		
		System.out.println("-------#07--------");
		empRepo.getAllEmpsList_TwoCol().stream().map(obj->obj[0] +" - "+obj[1]).forEach(System.out::println);
		System.out.println();
		
		
		System.out.println("---------------------PROJECTION (One Row)--------------------------");
		
		System.out.println("-------#08--------");
		Employee empObj =empRepo.getAllEmpById(105);
		System.out.println("empObj :"+empObj);
		System.out.println();
		
		
		System.out.println("-------#09--------");
		String empName=empRepo.getAllEmp_OneCol(105);
		System.out.println("empName :"+empName);
		System.out.println();
		
		System.out.println("-------#10--------");
		Object[] empobjArr=(Object[]) empRepo.getAllEmp_TwoCol(105);
		System.out.println("empobjArr :"+empobjArr[0] +" - "+empobjArr[1]);
		System.out.println();
		
		
		System.out.println("---------------------Updation--------------------------");
		empRepo.udpateEmpName("Sri Devi", 108);
		System.out.println();
		
		Employee updatedEmp=empRepo.getAllEmpById(108);
		System.out.println("updatedEmp :"+updatedEmp);
		
	}

}
