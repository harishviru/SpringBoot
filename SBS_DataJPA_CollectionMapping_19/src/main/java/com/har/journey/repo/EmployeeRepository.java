package com.har.journey.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.har.journey.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
