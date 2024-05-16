package com.har.journey.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	private Long empId;
	private String empName;
	private Double empSal;
	private String empDept;
	
	
	
}
