package com.har.journey.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.har.journey.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	
	//#01 . No IN and OUT Params
	@Query(value="CALL getAllEmps()",nativeQuery = true)
	List<Employee> getAllEmps();
	
	
	//#02 . One IN and No OUT Params
	@Query(value="CALL getEmpsByDept(?)",nativeQuery = true)
	List<Employee> getEmpsByDept(String dept);
	
	//#03. Here @Query will not support for OUT param i.e below Method will not works
	@Query(value="CALL getEmpCountByDept(?,?)",nativeQuery = true)
	List<Employee> getEmps(String dept);

	
	
	
}
