package com.har.journey.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(value="prod_col")
public class Product {
	@Id
	private String id;
	private Integer prodId;
	private String prodCode;
	private Double prodCost;
	
	private Double prodDisc;
	private Double prodGst;
	
}
