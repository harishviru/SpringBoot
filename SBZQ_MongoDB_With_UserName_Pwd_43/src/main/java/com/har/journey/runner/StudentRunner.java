package com.har.journey.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.har.journey.model.Student;
import com.har.journey.repo.StudentRepoistory;

@Component
public class StudentRunner implements CommandLineRunner{

	
	@Autowired
	private StudentRepoistory stRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		stRepo.save(new Student(101,"A",250.0));
		stRepo.findAll().forEach(System.out::println);
		
		
	}
}
