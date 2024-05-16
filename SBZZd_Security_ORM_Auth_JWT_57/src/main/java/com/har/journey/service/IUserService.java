package com.har.journey.service;

import java.util.Optional;

import com.har.journey.model.User;

public interface IUserService {

	 Integer saveUser(User user);
	
	 Optional<User> findByUsername(String username);
	 
}
