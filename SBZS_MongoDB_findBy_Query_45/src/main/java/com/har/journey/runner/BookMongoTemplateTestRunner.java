package com.har.journey.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.har.journey.model.Book;

//#04 : By Using MongoTemplate

@Component
public class BookMongoTemplateTestRunner implements CommandLineRunner {

	@Autowired
	private MongoTemplate mTemp;
	
	
	@Override
	public void run(String... args) throws Exception {

		//save
		Book dbBook =mTemp.save(new Book(203, "Mongo Template", 300, "Mongo SB", "SB Mongo DB"));
		System.out.println("dbBook :"+dbBook);
		
		Query query =new Query(Criteria.where("_id").is(103)); 
		Book book1=mTemp.findOne(query, Book.class);
		System.out.println("book1 :"+book1);
		System.out.println();
		
		List<Book> bookList = mTemp.findAll(Book.class);
		bookList.forEach(System.out::println);
		
	}

}
