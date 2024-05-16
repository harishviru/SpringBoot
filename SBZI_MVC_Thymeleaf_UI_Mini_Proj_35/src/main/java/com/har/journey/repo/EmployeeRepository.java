package com.har.journey.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.har.journey.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	
	@Query("SELECT Count(empEmail) FROM Employee e where e.empEmail=:email")
	public Long getEmailCount(String email);
	
	
}
