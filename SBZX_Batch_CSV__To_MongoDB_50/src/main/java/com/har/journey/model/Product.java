package com.har.journey.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	private Integer prodId;
	private String prodCode;
	private Double prodCost;
	
	private Double prodDisc;
	private Double prodGst;
	
}
