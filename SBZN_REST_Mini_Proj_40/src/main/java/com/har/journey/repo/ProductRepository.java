package com.har.journey.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.har.journey.model.Product;

import javax.transaction.Transactional;

public interface ProductRepository extends JpaRepository<Product, Long> {

	 @Transactional   // To commit OR  Rollback
	 @Modifying      // To enable Non-Select Query
	 @Query("UPDATE Product SET prodCode=:prodCode WHERE prodId=:prodId")
	 public Integer updateProdCodeById(String prodCode,Long prodId);
	
}
