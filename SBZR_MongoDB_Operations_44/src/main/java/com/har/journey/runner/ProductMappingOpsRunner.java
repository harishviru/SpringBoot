package com.har.journey.runner;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.har.journey.model.Customer;
import com.har.journey.model.Product;
import com.har.journey.model.Vendor;
import com.har.journey.repo.ProductRepository;

@Component
public class ProductMappingOpsRunner implements CommandLineRunner{

	@Autowired
	private ProductRepository pRepo;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		pRepo.deleteAll(); //clean DB
		
		Product prod =new Product();
		prod.setPid(1001);
		prod.setPcode("PQR");
		prod.setPcost(2000.0);
		
		//Collection Type :List
		List<String> pcolors =List.of("GREEN","BLUE","WHITE","YELLOW","RED"); 
		prod.setPcolors(pcolors);
		
		//Map
		Map<String,Integer> mcodes = Map.of(
				                           "AB12",12,
				                           "CB50",50,
				                           "RC100",100
				                          );
		
		prod.setMcodes(mcodes);
		
		//HAS-A
		Vendor vob   = new Vendor(101, "V120", "CONTRACT", "Hyd");
		prod.setVob(vob);
		
		//HAS-A : Collection Type
		List<Customer> cobs  =List.of(
				                        new Customer(801, "ABC", "988627191"),
				                        new Customer(802, "PQR", "988910134"),
				                        new Customer(803, "MNO", "962719298"),
				                        new Customer(804, "XYZ", "931041013")
				                      );
		
		prod.setCobs(cobs);
		
		//Finally save product
		pRepo.save(prod);
		
		//Read Product
		pRepo.findAll().forEach(System.out::println);
		
	}
}
