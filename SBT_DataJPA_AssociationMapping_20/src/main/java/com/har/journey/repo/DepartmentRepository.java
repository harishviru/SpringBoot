package com.har.journey.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.har.journey.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
