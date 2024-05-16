package com.har.journey.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="emp_one_tabe")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeOne {

	
	@Id
	@Column(name="emp_Id")
	private Integer empId;
	
	@Column(name="emp_name")
	private String empName;
	
	@Column(name="dept")
	private String dept;
	
}
