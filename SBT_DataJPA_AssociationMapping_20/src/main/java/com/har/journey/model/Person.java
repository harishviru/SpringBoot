package com.har.journey.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Person {

	@Id
	private Integer pid;
	private String fName;
	private String lName;
	private String contact;
	private String gender;
	
	/**              HAS-A
	 *     Person---------<>Profile
	 *            1...1
	 *            But we need to apply like
	 *            *...1 + 
	 *            (unique at many side)
	 */
	//@OneToOne
	@ManyToOne
	@JoinColumn(name = "pr_id_fk",unique = true)       // @ManyToOne + unique = true --->OneToOne
	private Profile prObj;
}
