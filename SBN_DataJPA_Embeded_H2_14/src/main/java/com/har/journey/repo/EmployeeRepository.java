package com.har.journey.repo;

import org.springframework.data.repository.CrudRepository;

import com.har.journey.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
