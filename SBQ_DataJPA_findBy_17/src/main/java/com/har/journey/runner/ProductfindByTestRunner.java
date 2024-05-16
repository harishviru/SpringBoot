package com.har.journey.runner;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.har.journey.model.Product;
import com.har.journey.repo.ProductRepository;

@Component
public class ProductfindByTestRunner implements CommandLineRunner {

	@Autowired
	private ProductRepository prodRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		prodRepo.save(new Product(101, "B-Pen", 10.0, "Rorito", "A"));
		prodRepo.save(new Product(102, "TV", 10000.0, "SAMSUNG", "A"));
		prodRepo.save(new Product(103, "Refrigetor", 900000.0, "LG", "B"));
		prodRepo.save(new Product(104, "Laptop", 80000.0, "Dell", "C"));
		prodRepo.save(new Product(105, "Mobile", 20000.0, "Oppo", "B"));
		prodRepo.save(new Product(106, "AC", 108899.0, "LG", "C"));
		prodRepo.save(new Product(107, "Heater", 12000.0, "SAMSUNG", "A"));
		prodRepo.save(new Product(108, "TV", 9000.0, "SAMSUNG", "B"));
		prodRepo.save(new Product(109, "tv", 30000.0, "LG", "C"));
		prodRepo.save(new Product(110, "TV", 70000.0, "Apple", "A"));
		
		System.out.println("----------------Data inserted successfully-----------------");
		System.out.println();
		
		//#01 .Basic Operation
		System.out.println("----------------findBy Basic Operation-----------------");
		prodRepo.findByProdVendor("LG").forEach(System.out::println);
		System.out.println();
		
		prodRepo.findByProdName("TV").forEach(System.out::println);
		System.out.println();
		
		
		prodRepo.findByProdGradeIs("A").forEach(System.out::println);
		System.out.println();
		
		prodRepo.findByProdGradeEquals("A").forEach(System.out::println);
		System.out.println();
		
		prodRepo.findByProdCostGreaterThan(20000.0).forEach(System.out::println);
		System.out.println();
		
		prodRepo.findByProdCostLessThanEqual(20000.0).forEach(System.out::println);
		System.out.println();
		
		prodRepo.findByProdCostBetween(20000.0,900000.0).forEach(System.out::println);
		System.out.println();
		
		
		//#02 .Like Operator
		System.out.println("----------------findBy Like Operator----------------");
		prodRepo.findByProdNameLike("B%").forEach(System.out::println);
		System.out.println();
		
		prodRepo.findByProdNameNotLike("B%").forEach(System.out::println);
		System.out.println();
		
		prodRepo.findByProdNameLike("%r").forEach(System.out::println);
		System.out.println();
		
		prodRepo.findByProdNameLike("%a%").forEach(System.out::println);
		System.out.println();

		
		prodRepo.findByProdNameLike("__").forEach(System.out::println); //Exact two chars
		System.out.println();
		
		prodRepo.findByProdNameStartingWith("A").forEach(System.out::println);
		System.out.println();
		
		prodRepo.findByProdNameEndingWith("r").forEach(System.out::println);
		System.out.println();

		
		prodRepo.findByProdNameContaining("a").forEach(System.out::println);
		System.out.println();

		//#3. And ,Or Operators --
		System.out.println("----------------findBy And ,Or Operators----------------");
		
		prodRepo.findByProdNameLikeAndProdCostGreaterThanEqual("%A%", 10000.0).forEach(System.out::println);
		System.out.println();
		
		prodRepo.findByProdNameLikeOrProdCostLessThan("A%", 10000.0).forEach(System.out::println);
		System.out.println();
		
		prodRepo.findByProdNameIn(Arrays.asList("Heater","TV")).forEach(System.out::println);
		System.out.println();
		

		//#4. Order by 
		System.out.println("----------------findBy OrderBy----------------");
		prodRepo.findByProdNameOrderByProdVendor("TV").forEach(System.out::println);
		System.out.println();
		
		prodRepo.findByProdNameOrderByProdVendorDesc("TV").forEach(System.out::println);
		System.out.println();
		
		//#5. IgnoreCase 
		System.out.println("----------------findBy IgnoreCase----------------");
		prodRepo.findByProdNameIgnoreCase("tv").forEach(System.out::println);
		
		//#6. Projection 
		System.out.println("----------------findBy <Projection>----------------");
		prodRepo.findByProdGrade("A").forEach(prod->System.out.println(prod.getProdName() +"  -  "+prod.getProdVendor()));
		
		
	}
}
