package com.har.journey.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {

	@Id
	private Integer bid;
	private String bname;
	private String btype;
	
	/**           HAS-A
	 *    Book ------<> Author
	 *          *...*
	 *           (ManyToMany) 
	 */
	
	@ManyToMany
	@JoinTable(name = "book_auth_tab",
			  joinColumns = @JoinColumn(name="bid_fk"),
			  inverseJoinColumns = @JoinColumn(name="aid_fk")
			)           //book_auth_tab Table is created with 2 columns
	private List<Author> autrs;
	
	
}
