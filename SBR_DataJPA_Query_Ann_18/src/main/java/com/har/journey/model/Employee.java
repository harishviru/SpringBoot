package com.har.journey.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="emp_tab_one")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

	@Id
	private Integer empId;
	private String empName;
	private String deptName;
	private Double empSal;
	
}
