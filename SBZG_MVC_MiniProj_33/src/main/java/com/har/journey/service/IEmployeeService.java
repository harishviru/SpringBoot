package com.har.journey.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.har.journey.model.Employee;

public interface IEmployeeService {
	
	Long saveEmployee(Employee employee);
	
	List<Employee> getAllEmpList();
	
	Page<Employee> getAllEmpList(Pageable pageable);
	
	void deleteEmp(Long empId);
	
	Employee getEmployeeId(Long empId);
	
	
	 void updateEmp(Employee employee,Long empId); 	
}
