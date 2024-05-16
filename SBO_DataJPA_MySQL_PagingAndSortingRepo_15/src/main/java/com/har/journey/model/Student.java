package com.har.journey.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="stud_tabe")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	
	@Id // PK ->Unique + not null
	@Column(name = "s_id")
	private Integer studId;
	
	//@Column(name = "s_name",length = 40,nullable = false)
	@Column(name = "s_name")
    private String studName;
	
	//@Column(name = "s_course",unique = true)
	@Column(name = "s_course")
    private String course;
	
	@Column(name = "s_fee")
    private Double fee;
	
	
}
