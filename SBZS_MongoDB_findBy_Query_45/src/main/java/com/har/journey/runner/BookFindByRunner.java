package com.har.journey.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.har.journey.model.Book;
import com.har.journey.repo.BookRepository;

//#02 : findBy

//@Component
public class BookFindByRunner implements CommandLineRunner {

	@Autowired
	private BookRepository bRepo;
	
	
	@Override
	public void run(String... args) throws Exception {
		//Equal,GreaterThan,GreaterThanEqual,LessThan,LessThanEqual,Between,is Null,is Not Null
		System.out.println("---------------------#01 .Basic Operations----------------");
		
		bRepo.findByTitle("Core Java").forEach(System.out::println);
		System.out.println();
		
		bRepo.findByAuthorIs("ABC").forEach(System.out::println);
		System.out.println();
		
		bRepo.findByNoOfPagesGreaterThan(300).forEach(System.out::println);
		System.out.println();
		
		
		bRepo.findByNoOfPagesLessThanEqual(300).forEach(System.out::println);
		System.out.println();
		
		bRepo.findByNoOfPagesBetween(300,450).forEach(System.out::println);
		System.out.println();
		
		bRepo.findByAuthorIsNull().forEach(System.out::println);
		System.out.println();
		
		bRepo.findByAuthorIsNotNull().forEach(System.out::println);
		System.out.println();
		
		//(Like ,Not Like,StartingWith,EndingWith,Containing)
		System.out.println("---------------------#02. Like Operator----------------");
		
		bRepo.findByAuthorStartingWith("A").forEach(System.out::println);
		System.out.println();
		
		bRepo.findByAuthorContaining("A").forEach(System.out::println);
		System.out.println();
		
		bRepo.findByBtypeNotLike("A").forEach(System.out::println);
		System.out.println();
		
		
		 
		//---------------------#3. And ,Or,In Operators -----------------------------------------------
		System.out.println("---------------------#03. And ,Or,In Operators----------------");
				
		bRepo.findByAuthorAndTitle("ABC", "Core Java").forEach(System.out::println);
		System.out.println();
		
		
		bRepo.findByAuthorOrTitle("ABC", "Core Java").forEach(System.out::println);
		System.out.println();
		
		bRepo.findByBtypeIn("BackEnd").forEach(System.out::println);
		System.out.println();
		
		
		System.out.println("---------------------#4. Order by ----------------");
				
		bRepo.findByAuthorOrderByBtype("ABC").forEach(System.out::println);
		System.out.println();
		
		bRepo.findByAuthorOrderByBtypeDesc("ABC").forEach(System.out::println);
		System.out.println();
		
		System.out.println("---------------------#5.Projections----------------");
		
		bRepo.findByAuthor("ABC").forEach(myView->System.out.println(myView.getAuthor() +" ---- "+myView.getTitle()));
		
		System.out.println("---------------------#6.Single Record----------------");
		
		Book book =bRepo.findByIdAndAuthor(103,"ABC");
		System.out.println(" book :"+book);
	}

}
