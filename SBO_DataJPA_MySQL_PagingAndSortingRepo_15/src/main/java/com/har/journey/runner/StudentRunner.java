package com.har.journey.runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import com.har.journey.model.Student;
import com.har.journey.repo.StudentRepository;
import com.har.journey.repo.StudentSortPageableRepository;

@Component
public class StudentRunner implements CommandLineRunner {

	@Autowired
	private StudentRepository studRepo; //CrudRepository
	
	@Autowired
	private StudentSortPageableRepository studPageRepo; //PagingAndSortingRepository

	@Override
	public void run(String... args) throws Exception {

		
		studRepo.saveAll(
				Arrays.asList(
						new Student(101, "Harish", "Java", 4000.0), 
						new Student(102, "Renuka", ".Net", 5000.0),
						new Student(103, "Vamsi", "Php", 7000.0),
						new Student(104, "Ramesh", "SQL", 3000.0),
						new Student(105, "Suresh", "SB", 600.0),
						new Student(106, "Ganga", "MS", 300.0),
						new Student(107, "Pallavi", "SQL", 2000.0),
						new Student(108, "Chandra", "SB", 4000.0),
						new Student(109, "Vivek", "Php", 6000.0), 
						new Student(110, "Santhosh", "SQL", 1000.0),
						new Student(111, "Laxmi", "SB", 6000.0),
						new Student(112, "Bhoomi", "Java", 7000.0)
						)
				);

		System.out.println("------------findAll()-------------------------");
		studRepo.findAll().forEach(emp->System.out.println(emp));
		
		System.out.println("------------Sorting---------------------------");
		
		//Sorting
		//Sort sort=Sort.by("studName"); //Default Direction.ASC
		Sort sort=Sort.by(Direction.DESC,"studName");
		
		Iterable<Student> studSort= studPageRepo.findAll(sort);
		studSort.forEach(emp->System.out.println(emp));
		System.out.println();
		
		System.out.println("------------Pagination---------------------------");
		//Pagination
        PageRequest pageInput =PageRequest.of(1, 3); //PageRequest.of(int pageNumber, int pageSize);
		
	  //PageRequest pageInput =PageRequest.of(1, 3,Sort.by(Direction.DESC,"studName")); 
		
		Page<Student> page= studPageRepo.findAll(pageInput);
		
		List<Student>  studList =page.getContent();
		studList.forEach(emp->System.out.println(emp));
		
		//Additional Information
		System.out.println("Is First Page :"+ page.isFirst());
		System.out.println("Is Last Page  :"+page.isLast());
		System.out.println("Is Empty Page :"+page.isEmpty());
		System.out.println("Has Next Page :"+page.hasNext());
		System.out.println("Has Previous Page :"+page.hasPrevious());
		System.out.println("Current Page Number :"+page.getNumber());
		System.out.println("Total Pages :"+ page.getTotalPages());
		System.out.println("Total Rows :"+page.getTotalElements());
		
		
		
		
		
	}

}
