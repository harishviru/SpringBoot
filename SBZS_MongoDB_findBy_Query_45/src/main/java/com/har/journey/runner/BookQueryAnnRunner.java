package com.har.journey.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.har.journey.repo.BookRepository;

//#03 : @Query

//@Component
public class BookQueryAnnRunner implements CommandLineRunner {

	@Autowired
	private BookRepository bRepo;

	
	@Override
	public void run(String... args) throws Exception {

		
		System.out.println("-------------------------#01. Only Restriction  (protecting all variables)--------------------------------------------");
		
		bRepo.getBooksByAuthor("ABC").forEach(System.out::println);
		System.out.println();
		
		bRepo.getBooksByAuthorAndTitle("ABC","Core Java").forEach(System.out::println);
		System.out.println();
		
		bRepo.getBooksByNOofPagesCond(200).forEach(System.out::println);
		System.out.println();
		
		
		bRepo.getBooksByNOofPagesConds(600,900).forEach(System.out::println);
		System.out.println();
		
		bRepo.getAuthorsIn(List.of("ABC","PQR")).forEach(System.out::println);
		System.out.println();
		
		
		bRepo.getBooksByType("FrontEnd").forEach(System.out::println);
		System.out.println();
		
		bRepo.getBooksByTypeAndNotNull("BackEnd").forEach(System.out::println);
		System.out.println();
		
		
		bRepo.getBooksByTypeAndGtNoOfPage("BackEnd",400).forEach(System.out::println);
		System.out.println();
		
		bRepo.getBooksByAuthorAndType("ABC","BackEnd").forEach(System.out::println);
		System.out.println();
		
		bRepo.getBooksByAuthorOrType("ABC","BackEnd").forEach(System.out::println);
		System.out.println();
		
		bRepo.getBooksByAuthorNotVal("ABC").forEach(System.out::println);
		System.out.println();
		
		System.out.println("-------------------------#02. Restriction with Projections (1 : enable ,0: disable in fields attribute value)-------------------------------------------");

		bRepo.getBooksByTitle("Core Java").forEach(System.out::println);
		System.out.println();
		
		
		bRepo.getBooksByTitleStr("Core Java").forEach(System.out::println);
		System.out.println();
		
		bRepo.getBooksByTitleStrDisableId("Core Java").forEach(System.out::println);
		System.out.println();
		
		bRepo.getBookObjByAuthor("ABC").forEach(myView->{
			System.out.println(myView.getClass().getSimpleName());
			System.out.println(myView.getAuthor() +" ----"+myView.getTitle());
			System.out.println("myView :"+myView);
		});
		System.out.println();
		
		System.out.println("-------------------------#03.Sorting / Count--------------------");
		//Sorting
		bRepo.getBooksInfoByType("BackEnd").forEach(System.out::println);
		System.out.println();
		
		//Count
		Long countVal =bRepo.getBtypeInCount(List.of("BackEnd"));
		System.out.println("countVal :"+countVal);
		System.out.println();
		
		System.out.println("-------------------------#04.update ,Delete--------------------");
		
		bRepo.updateTitle("HK", "NEW_HK");
		System.out.println();
		
		Long deleteCount =bRepo.deleteAuthorByName("PK");
		System.out.println("deleteCount :"+deleteCount);
		
		
	}

}
