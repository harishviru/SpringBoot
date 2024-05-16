package com.har.journey.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.har.journey.model.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

//#02 . ii)JPA 2.x API  By using EntityManager

@Component
@Order(3)
public class JPABasedProcedureCallTestRunner implements CommandLineRunner {

	@Autowired
	private EntityManager em;
	
	
	@Override
	public void run(String... args) throws Exception {
		 System.out.println("___________________02. By Using JPA 2.X API EntityManager_____________________ ");
		//#---------------------------No IN and OUT param
		 
		System.out.println("-----i)No IN and OUT param----------");
		//Step#01 .Create StoredProcedureQuery object by using em by passing procedureName ,resultClasses
		StoredProcedureQuery spQuery =em.createStoredProcedureQuery("getAllEmps",Employee.class);
		
		//Step#02. provide inputs params and register Output params
		//nothing
		
		// Step#3 Execute query
		List<Employee> empList =spQuery.getResultList();
		
		empList.forEach(System.out::println);
		System.out.println();
		
		
		 System.out.println("-----ii) One IN and No OUT Param----------");
		//Step#01 .Create StoredProcedureQuery object by using em by passing procedureName ,resultClasses
	     StoredProcedureQuery spQueryOne =em.createStoredProcedureQuery("getEmpsByDept",Employee.class);
	     
	     //Step#02. Register and provide inputs and Output params
	     
	     //Register IN Param
	     spQueryOne.registerStoredProcedureParameter("edept", String.class, ParameterMode.IN);
			
	     //provide Value
	     spQueryOne.setParameter("edept","DEV");
		
	     //Step#3 Execute query
		  List<Employee> empList1 =spQueryOne.getResultList();
			
		  empList1.forEach(System.out::println);
		  System.out.println();
		  
		  System.out.println("-----iii) Both IN and OUT Param----------");
		//Step#01 .Create StoredProcedureQuery object by using em by passing procedureName ,resultClasses
		 StoredProcedureQuery spQueryTwo =em.createStoredProcedureQuery("getEmpCountByDept");
		 
         //Step#02. Register and provide inputs and Output params
	     
	     //Register IN ,OUT Param
		 spQueryTwo.registerStoredProcedureParameter("edept", String.class, ParameterMode.IN);
		 spQueryTwo.registerStoredProcedureParameter("dcount", Integer.class, ParameterMode.OUT);
			

	     //provide Value
		 spQueryTwo.setParameter("edept","BA");
		
		   
		 //Step#3 Execute query
		  spQueryTwo.execute();
		  
		  //read Out param
		 Integer dcount= (Integer) spQueryTwo.getOutputParameterValue("dcount");
		 
		 System.out.println("dcount :"+dcount);
			
		
	}

}
