package com.har.journey.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="prod_tab")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	@Id
	private Integer prodId;
	private String prodName;
	private Double prodCost;
	private String prodVendor;
	private String prodGrade;
	
}
