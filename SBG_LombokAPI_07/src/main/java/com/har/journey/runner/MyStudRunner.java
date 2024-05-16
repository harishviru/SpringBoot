package com.har.journey.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.har.journey.model.Employee;
import com.har.journey.model.Product;
import com.har.journey.model.Student;

@Component
public class MyStudRunner implements CommandLineRunner{

	
	@Override
	public void run(String... args) throws Exception {

		Student s1=new Student();
		s1.setSchoolName("Chaitanya School");
		s1.setStudName("Harish");
		s1.setStudId(209);
		
		System.out.println(s1);
		System.out.println(s1.getSchoolName() +" - "+s1.getStudName() +" - "+s1.getStudId());
		
		Student s2=new Student();
		s2.setSchoolName("Jyothi School");
		s2.setStudName("Arjun");
		s2.setStudId(212);
		
		Student s3=new Student();
		s3.setSchoolName("Jyothi School");
		s3.setStudName("Arjun");
		s3.setStudId(212);
		
		System.out.println(s2==s3); //false [== operator compares object reference
		System.out.println(s2.equals(s3));  // .equals() method overridden in Student class,then It compares data
		
		
		System.out.println("----------------------------------");
		Employee e1=new Employee();
		System.out.println(e1);
		
		Employee e2=new Employee("Brillio");
		System.out.println(e2);
		
		Employee e3=new Employee(120, "Swetha", "Brillio");
		System.out.println(e3);
		
		System.out.println("----------------------------------");
		Product p1=new Product();
		System.out.println(p1);
	}
}
