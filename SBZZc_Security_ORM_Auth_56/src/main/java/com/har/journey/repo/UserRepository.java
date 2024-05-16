package com.har.journey.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.har.journey.model.User;

public interface UserRepository  extends JpaRepository<User, Integer>{

	
	Optional<User> findByEmail(String email);

}
