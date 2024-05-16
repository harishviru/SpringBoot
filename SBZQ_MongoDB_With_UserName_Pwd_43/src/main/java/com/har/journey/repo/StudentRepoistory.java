package com.har.journey.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.har.journey.model.Student;

public interface StudentRepoistory extends MongoRepository<Student, Integer>{

}
