package com.har.journey.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

public class MyItemWriter implements ItemWriter<String> {

	@Override
	public void write(List<? extends String> items) throws Exception {
		System.out.println("From ItemWriter count is :"+items.size()+"  items :"+items);
	}
	
}
