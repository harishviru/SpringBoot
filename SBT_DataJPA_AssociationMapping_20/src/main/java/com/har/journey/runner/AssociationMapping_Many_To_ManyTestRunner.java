package com.har.journey.runner;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.har.journey.model.Author;
import com.har.journey.model.Book;
import com.har.journey.repo.AuthorRepository;
import com.har.journey.repo.BookRepository;

/*      ManyToMany (multiplicity)
        Book ----<>Author
*/
@Component
@Order(4)
public class AssociationMapping_Many_To_ManyTestRunner implements CommandLineRunner {

	@Autowired
	private AuthorRepository authRepo;
	
	@Autowired
	private BookRepository bkRepo;
	
	@Override
	public void run(String... args) throws Exception {
     Author a1=new Author(61, "NAKSHATRA", "BAN");
     Author a2=new Author(62, "SRIDEVI", "VIZAG");
     Author a3=new Author(63, "BHOOMIKA", "HYD");
     Author a4=new Author(64, "RAHUL", "CHN");
		
     authRepo.save(a1);
     authRepo.save(a2);
     authRepo.save(a3);
     authRepo.save(a4);
     
     Book b1 =new Book(98001, "CORE JAVA", "PRGM", List.of(a2,a3));
     Book b2 =new Book(98002, "DP", "THEORY", List.of(a1,a2));
     Book b3 =new Book(98003, "CODE TYPE", "MATHS", List.of(a3,a4));
	
     bkRepo.save(b1);
     bkRepo.save(b2);
     bkRepo.save(b3);

		
	  System.out.println("__________________(MANY_TO_MANY)________SUCCESSFULLY INSERTED____________________________");
	}

}
