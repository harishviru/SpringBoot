package com.har.journey.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Document(value = "empl_col") //To specify the collection Name
public class Employee {

	
	@Id     //MongoDB Generate Unique Number(HexaDecimal Number-> 0-9,A,B,C,D,E,F) Note : if datatype is String then only MongoDB server will generate id value 
	private String id;
	
	@NonNull
	private String ename;
	@NonNull
	private String dept;
	@NonNull
	private Double esal;
	
}
