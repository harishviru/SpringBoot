package com.har.journey.prod.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.har.journey.prod.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
