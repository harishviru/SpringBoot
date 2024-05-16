package com.har.journey.service.imp;

import java.util.List;
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
import com.har.journey.service.IUserService;

@Service
public class UserServiceImp implements IUserService, UserDetailsService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private BCryptPasswordEncoder pwdEncoder;
	
	
	@Override
	public Integer saveUser(User user) {
		
		String pwd =user.getPassword();
		user.setPassword(pwdEncoder.encode(pwd));
		user =userRepo.save(user);
		return user.getId();
	}
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<User> user = userRepo.findByEmail(username);
		
		if(!user.isPresent()) {
			throw new UsernameNotFoundException(username + "Not exist!");
		}else {
			User userObj= user.get();
			List<SimpleGrantedAuthority> authoritiesList = userObj.getRoles().stream().map(role->new SimpleGrantedAuthority(role)).collect(Collectors.toList());
			return new org.springframework.security.core.userdetails.User(userObj.getEmail(), userObj.getPassword(), authoritiesList);
		}
	}

	

}
