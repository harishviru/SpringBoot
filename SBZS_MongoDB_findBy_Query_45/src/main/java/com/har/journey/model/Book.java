package com.har.journey.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document
public class Book {

	@Id
	private Integer id; 
	private String title;
	private Integer noOfPages;
	private String author;
	private String btype;
	
	
	
	
}
