package com.har.journey.model;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="emp_two_tabe")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeTwo {

	
	@Id
	@Column(name="emp_Id")
	private Integer empId;
	
	@Column(name="emp_name")
	private String empName;
	
	@Column(name="dept")
	private String dept;
	
	@jakarta.persistence.Temporal(TemporalType.DATE)     //DATE : day/month/year
 	private Date dateA;
	@Temporal(TemporalType.TIME)     //TIME : Hrs:Min:sec   
	private Date dateB;
	@Temporal(TemporalType.TIMESTAMP) //TIMESTAMP : Both Date and time
	private Date dateC;
	
	private Date dateD;
	
	//For Date variable if we won't apply @Temporal annotation then by default it will consider as TemporalType.TIMESTAMP

	
}
