package com.har.journey.util;

import com.har.journey.model.Product;

public interface ProductUtil {

	public static void copyProduct(Product dbProduct,Product product) {
		if(product.getProdCode()!=null)
			dbProduct.setProdCode(product.getProdCode());
		if(product.getProdCost()!=null)
			dbProduct.setProdCost(product.getProdCost());
		if(product.getProdExpDt()!=null)
			dbProduct.setProdExpDt(product.getProdExpDt());
		
	}
	
	
}
