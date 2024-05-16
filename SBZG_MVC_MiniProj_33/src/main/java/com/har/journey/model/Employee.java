package com.har.journey.model;

import java.util.List;

import jakarta.annotation.Nonnull;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OrderColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="emp_min_tab")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	
	@Id         // To Make PK
	@GeneratedValue  //To Generate PK value by using sequence
	private Long empId;
	
	private String empName;
	@Nonnull
	private String empEmail;
	private Double empSal;
	private String empGender;   //radio
	@ElementCollection
	@CollectionTable(name="emp_fav_colors",joinColumns = @JoinColumn(name="empId"))  //Key Column | Join column
	@OrderColumn(name="pos")           //Index column
	@Column(name="emp_fav_col")        //element column
	private List<String> empFavColors;  //checkbox
	
	private Double empHr;
	private Double empDa;
	
	private String empDept;   // Select <Single>
	@ElementCollection
	@CollectionTable(name="emp_projects",joinColumns = @JoinColumn(name="empId"))  //Key Column | Join column
	@OrderColumn(name="pos")      //Index column
	@Column(name="emp_prjs")
	private List<String> empPrjs;   // Select <Multiple>
	
	
	
	
}
