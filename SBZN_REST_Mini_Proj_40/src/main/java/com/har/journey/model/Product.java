package com.har.journey.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="prod_tab")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long prodId;
	
	private String prodCode;
	private Double prodCost;
    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "IST")
	private Date prodExpDt;
	
	private Double prodGst;
	private Double prodDisc;
	
	public Product(String prodCode, Double prodCost, Date prodExpDt) {
		this.prodCode = prodCode;
		this.prodCost = prodCost;
		this.prodExpDt = prodExpDt;
	}
	
	
}
