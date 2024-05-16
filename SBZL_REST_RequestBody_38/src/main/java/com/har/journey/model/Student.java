package com.har.journey.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

	private Integer studId;
	private String studName;
	private Double studFee;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date dob;
	
	
	
}
