package com.har.journey.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.har.journey.model.Book;
import com.har.journey.repo.BookRepository;

//#01

//@Component
public class BookDataRunner implements CommandLineRunner {

	@Autowired
	private BookRepository bRepo;
	
	@Override
	public void run(String... args) throws Exception {

		bRepo.save(new Book(101, "Core Java", 180, "ABC", "BackEnd"));
		bRepo.save(new Book(102, "Adv Java",  220, "XYZ", "BackEnd"));
		bRepo.save(new Book(103, "SB Microservice", 500, "ABC", "BackEnd"));
		bRepo.save(new Book(104, "HTML", 280, "PQR", "FrontEnd"));
		bRepo.save(new Book(105, "Angular", 320, "ABC", "FrontEnd"));
		bRepo.save(new Book(106, "React Js", 430, "MNO", "FrontEnd"));
		bRepo.save(new Book(107, "Hibernate", 360, "PQR", "BackEnd"));
		bRepo.save(new Book(108, "Oracle", 890, "XYZ", "BackEnd"));
		
	}

}
