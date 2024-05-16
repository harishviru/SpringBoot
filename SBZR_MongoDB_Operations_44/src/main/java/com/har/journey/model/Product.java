package com.har.journey.model;

import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
public class Product {
	
	
	@Id
	private String id;
	
	private Integer pid;
	private String pcode;
	@Field(value = "p_cost")
	private Double pcost;
	
	
	//Collection
	private List<String> pcolors;
	private Map<String,Integer> mcodes;
	
	
	//HAS-A
	private Vendor vob;
	//HAS-A >CollectionType
	private List<Customer> cobs;
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
