package com.har.journey.prod.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//H2 DB

@Entity
@Table(name="product_tab")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String pcode;
	private Double pcost;
	
	
}
