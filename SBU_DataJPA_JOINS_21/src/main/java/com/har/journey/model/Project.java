package com.har.journey.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Project {

	@Id
	private Integer pid;
	private String pcode;
	private Double pcost;
	private String client;
	
}
