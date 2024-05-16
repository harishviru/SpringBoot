package com.har.journey.service;

import java.util.List;

import com.har.journey.model.Product;

public interface ProductService {

	Long saveProduct(Product product);
	
	List<Product> getAllProducts();
	Product getProduct(Long prodId);
	
	
	void deleteProduct(Long prodId);
	boolean productExist(Long prodId);
	
	
	void updateProduct(Product product);
    void updateProdCodeById(Long prodId,String prodCode);
	
}
