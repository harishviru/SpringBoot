package com.har.journey.model;

import lombok.Data;

@Data
public class Product {

	private Integer prodId;
	private String prodCode;
	private Double prodCost;
	
	private Double prodDisc;
	private Double prodGst;
	
}
