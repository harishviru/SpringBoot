package com.har.journey.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.har.journey.model.Product;

public interface ProductRepository  extends MongoRepository<Product, String>{
	
	
}


