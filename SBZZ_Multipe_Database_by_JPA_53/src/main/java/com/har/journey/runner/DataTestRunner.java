package com.har.journey.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.har.journey.cust.model.Customer;
import com.har.journey.cust.repo.CustomerRepository;
import com.har.journey.prod.model.Product;
import com.har.journey.prod.repo.ProductRepository;

@Component
public class DataTestRunner implements CommandLineRunner{
   
	@Autowired
	private ProductRepository pRepo;
	
	@Autowired
	private CustomerRepository cRepo;
	
	@Override
	public void run(String... args) throws Exception {
		Product p =new Product();
		p.setPcode("PEN");
		p.setPcost(29.0);
		pRepo.save(p);
		
		Customer c=new Customer();
		c.setCname("K");
		c.setCAddrs("CHN");
		cRepo.save(c);
		System.out.println("Data saved successfully");
		
	}
}
