package com.har.journey.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

	
	@Id        //MongoDB will not Generate Unique Number becoz datatype is Integer
	private Integer srollNo;
	private String sName;
	private Double sfee;
	
}
