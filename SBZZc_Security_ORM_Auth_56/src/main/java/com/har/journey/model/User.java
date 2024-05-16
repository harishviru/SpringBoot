package com.har.journey.model;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="user_det_tab")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="uid")
	private Integer id;
	
	@Column(name="uname")
	private String username;
	
	@Column(name="uemail")
	private String email;
	
	@Column(name="upwd")
	private String password;
	
	@Column(name="uenabled")
	private boolean enabled =Boolean.TRUE;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable( name = "roles_tab",joinColumns = @JoinColumn(name="uid"))
	@Column(name="role")
	private Set<String> roles;
	
	
}
