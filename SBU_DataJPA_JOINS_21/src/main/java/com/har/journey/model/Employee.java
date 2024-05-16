package com.har.journey.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="emp_join_tab")
public class Employee {

	@Id
	private Integer eid;
	private String ename;
	private Double esal;
	private String addr;
	
	/*                  HAS-A
	 *        Employee---------<>Project
	 *                  1...*
	 */
	
	@OneToMany
	@JoinColumn(name="eid_fk")
	private List<Project> prjs;
	
}
