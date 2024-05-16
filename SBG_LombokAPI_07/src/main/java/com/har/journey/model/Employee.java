package com.har.journey.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@NoArgsConstructor   //0-param constructor
@AllArgsConstructor   //all(3) param constructor
@RequiredArgsConstructor //1-param (@NonNull consider) constructor
                         //if @NonNull not found ,then 0-param constructor
@ToString
public class Employee {

	
	private Integer empId;
	private String empName;
	@NonNull
	private String empComp;
	
	
}
