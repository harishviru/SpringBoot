package com.har.journey.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "empTab")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Employee {

	@Id
	@Column(name = "eid")
	@GeneratedValue   // It generate Id value to eid  column internally ,if you not provide this @GeneratedValue annotation we need to set manually before calling persist methods           
	private Integer empId;
	@Column(name = "ename")
	@NonNull
	private String empName;
	
	@Column(name = "esal")
	@NonNull
	private Double empSal;
}
