package com.har.journey.repo;

import org.springframework.data.repository.CrudRepository;

import com.har.journey.model.Student;

public interface StudentRepository extends CrudRepository<Student, Integer>{

}
