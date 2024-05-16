package com.har.journey.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Model {

	
	private Integer mid;
	private String mcode;
	private Double mcost;
	
	private Vendor von;
	
}
