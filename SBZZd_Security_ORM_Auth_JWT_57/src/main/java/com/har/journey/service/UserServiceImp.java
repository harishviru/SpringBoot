package com.har.journey.service;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.har.journey.model.User;
import com.har.journey.repo.UserRepository;

@Service
public class UserServiceImp implements IUserService ,UserDetailsService{

	@Autowired
	private UserRepository uRepo;
	
	@Autowired
	private BCryptPasswordEncoder pwdEncoder;
	
	@Override
	public Integer saveUser(User user) {
		user.setPassword(pwdEncoder.encode(user.getPassword()));
		return uRepo.save(user).getId();
	}
	@Override
	public Optional<User> findByUsername(String username) {
		return uRepo.findByUsername(username);
	}
    ////////////////// >UserDetailsService< //////////////////////////
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> opt =findByUsername(username);
		if(opt.isEmpty())
			throw new UsernameNotFoundException("User "+username+" not exit..!");
		
		User user=opt.get();
		return new org.springframework.security.core.userdetails.User(
				                            user.getUsername(), 
				                            user.getPassword(),
				                            user.getRoles().stream()
				                            .map(role->new SimpleGrantedAuthority(role))
				                            .collect(Collectors.toList()));
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
