package com.har.journey.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.har.journey.exception.ProductNotFoundException;
import com.har.journey.model.Product;
import com.har.journey.repo.ProductRepository;
import com.har.journey.service.ProductService;

@Service
public class ProductServiceImp implements ProductService {

	@Autowired
	private ProductRepository prodRepo;

	@Override
	public Long saveProduct(Product product) {
		Double prodCost = product.getProdCost();
		if (prodCost != null && prodCost>0.0) {
			Double prodGst  = prodCost * 12 / 100;
			Double prodDisc = prodCost * 20 / 100;
			product.setProdGst(prodGst);
			product.setProdDisc(prodDisc);
		}
		Product prodDb = prodRepo.save(product);
		return prodDb.getProdId();
	}
	
	@Override
	public List<Product> getAllProducts() {
		return prodRepo.findAll();
	}
	
	@Override
	public Product getProduct(Long prodId) {
		
	/*	Optional<Product> optProd =prodRepo.findById(prodId);
		if(optProd.isPresent()) {
			return optProd.get();
		}else {
			throw new ProductNotFoundException("Product '"+prodId+"' Not Exist");
		} */
		return prodRepo.findById(prodId).orElseThrow(()->new ProductNotFoundException("Product '"+prodId+"' Not Exist"));
	}
	
	@Override
	public boolean productExist(Long prodId) {
		return prodRepo.existsById(prodId);
	}
	
	@Override
	public void deleteProduct(Long prodId) {
	/*	if(productExist(prodId)) {
			prodRepo.deleteById(prodId);
		}else {
			throw new ProductNotFoundException("Product '"+prodId+"' Not Exist");
		} */
		Product product =getProduct(prodId);
		prodRepo.delete(product);
	}
	
	
	@Override
	public void updateProduct(Product product) {
		Double prodCost = product.getProdCost();
		if (prodCost != null && prodCost>0.0) {
			Double prodGst  = prodCost *12 / 100;
			Double prodDisc = prodCost *20 / 100;
			product.setProdGst(prodGst);
			product.setProdDisc(prodDisc);
		}
		prodRepo.save(product);
	}
	
	@Override
	public void updateProdCodeById(Long prodId, String prodCode) {
		if(productExist(prodId)) {
			prodRepo.updateProdCodeById(prodCode, prodId);
		}else {
			throw new ProductNotFoundException("Product '"+prodId+"' Not Exist");
		}
	}
	

}
