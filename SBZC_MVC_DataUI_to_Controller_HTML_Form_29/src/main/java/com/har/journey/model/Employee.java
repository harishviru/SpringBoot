package com.har.journey.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	
	private Integer empId;      //type =text
	private String empName;    //type =text
	private Double empSal;    //type =text
	private String empPwd;    //type =Password

	private String empGen;    //type =radio
	private String empDept;   //type =select  (SINGLE)
	private String empAddr;   //type =textarea 
	
	private List<String> empLang;  //type="checkbox" 
	private List<String> empProjs;  //type =select  (MULTIPLE)
	
	private String empColor;
	private String empDte;
	private String empTme;
	private String empDateTme;
	private String empFile;
	
}
