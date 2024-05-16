package com.har.journey.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.OrderColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="emp_tab_col")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

	@Id
	@Column(name="eid")
	private Integer empId;
	@Column(name="ename")
	private String empName;
	@Column(name="edept")
	private String deptName;
	@Column(name="esal")
	private Double empSal;
	
	@ElementCollection
	@CollectionTable(name ="emp_projs_tab" ,joinColumns = @JoinColumn(name="eid"))  //Key Column | Join column
	@OrderColumn(name="pos")   // index column
	@Column(name="projs") //element column
	List<String> empPrjs;
	
	@ElementCollection
	@CollectionTable(name="emp_tasks_tab",joinColumns = @JoinColumn(name="eid"))  //Key Column | Join column
	@Column(name="task")   //element column
	Set<String> empTasks;
	
	@ElementCollection
	@CollectionTable(name="emp_Modules_tab",joinColumns = @JoinColumn(name="eid")) //Key Column | Join column
	@MapKeyColumn(name="pos")  //Index column
 	@Column(name="module")       //element column
	Map<Integer,String> empModules;
	
	
	@ElementCollection
	@OrderColumn(name="pos")
	List<String> empTeamMembers;
	
	
}
