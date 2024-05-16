package com.har.journey.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Vendor {

	@Id
	private Integer vid;
	private String vname;
	private String vAddrs;
	
	/**   
	 *  Vendor ------<> Contract
	 *           1...*
	 *          (OneToMany)
	 */
	
	@OneToMany(cascade = CascadeType.ALL) //Cascading in Hibernate refers to the automatic persistence of related entities. When a change is made to an entity, such as an update or deletion, the changes can be cascaded to related entities as well. Cascading can be configured using annotations, such as @OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="vid_fk")
	private List<Contract> conObjs;
}
