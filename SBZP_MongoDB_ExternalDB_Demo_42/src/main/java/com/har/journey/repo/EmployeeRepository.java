package com.har.journey.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.har.journey.model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String>{

}
