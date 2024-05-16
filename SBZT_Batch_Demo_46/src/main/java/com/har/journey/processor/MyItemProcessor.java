package com.har.journey.processor;

import org.springframework.batch.item.ItemProcessor;

public class MyItemProcessor implements ItemProcessor<String, String> {

	@Override
	public String process(String item) throws Exception {
		 System.out.println("FROM ItemProcessor : "+item);
		 return item;
	}
	
}
