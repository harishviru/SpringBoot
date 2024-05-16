package com.har.journey.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="emp_tab_ass_ap")
public class Employee {

	@Id
	private Integer id;
	private String name;
	
	// *...1  (ManyToOne)
	//  Employee----<> Department
	
	@ManyToOne
	@JoinColumn(name="dpt_Fk")
	private Department dept;
}
