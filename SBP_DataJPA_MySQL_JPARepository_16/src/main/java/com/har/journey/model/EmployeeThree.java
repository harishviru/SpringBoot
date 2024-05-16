package com.har.journey.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="emp_three_tabe")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeThree {

	
	@Id
	@Column(name="emp_Id")
	private Integer empId;
	
	@Column(name="emp_name")
	private String empName;
	
	@Column(name="dept")
	private String dept;

	@Lob // BLOB
	private char[] empDescr;

	@Lob // CLOB
	@Column(columnDefinition = "longblob")
	private byte[] empImage;
}
