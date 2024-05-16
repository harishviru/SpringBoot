package com.har.journey.processor;

import org.springframework.batch.item.ItemProcessor;

import com.har.journey.model.Product;

public class MyProductItemProcessor implements ItemProcessor<Product, Product> {
	
	@Override
	public Product process(Product prodItem) throws Exception {

		var prodCost =prodItem.getProdCost();
		var prodDisc =(prodCost*25)/100;
		var prodGst  =(prodCost*12)/100;

		prodItem.setProdDisc(prodDisc);
		prodItem.setProdGst(prodGst);
		return prodItem; //Return Product Item to Writer
	}
}
