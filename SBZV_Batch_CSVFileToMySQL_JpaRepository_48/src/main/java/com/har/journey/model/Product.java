package com.har.journey.model;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="product_bat")
public class Product {
    @Id
	private Integer prodId;
	private String prodCode;
	private Double prodCost;
	
	private Double prodDisc;
	private Double prodGst;
	
}
