package com.har.journey.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.har.journey.model.User;
import com.har.journey.model.UserRequest;
import com.har.journey.model.UserResponse;
import com.har.journey.service.IUserService;
import com.har.journey.util.JWTUtil;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService iUserService;
	
	@Autowired
	private JWTUtil jwtUtil;
	
	
	//Save User data  in DB >: Register
	@PostMapping("/save")
	public ResponseEntity<String> saveUser(@RequestBody User user){
		Integer id=iUserService.saveUser(user);
		return ResponseEntity.ok("User "+id +" created Successfully..!");
	}
	
	//Validate the user and generate the token
	@PostMapping("/login")
	public ResponseEntity<UserResponse> loginUser(@RequestBody UserRequest userReq){
		//TODO : Validate user with DB user
		//Generate the token
		String token  =jwtUtil.generateToken(userReq.getUsername());
		return ResponseEntity.ok(new UserResponse(token, "Successfully Generated Token..!"));
	}
	
	
	//Resource 
	@GetMapping("/welcome")
	public ResponseEntity<String> showWelcome(Principal principal){
		return ResponseEntity.ok("Welcome to JWT + Security "+principal.getName());
	}
	

	
	
}
