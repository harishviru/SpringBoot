package com.har.journey.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.har.journey.model.User;
import com.har.journey.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;
	
	//#01. Show User Register Form
	@GetMapping("/register")
	public String showRegForm() {
		return "UserRegister";
	}
	
	//#02. Save UserDetails
	@PostMapping("/save")
	public String saveUser(@ModelAttribute User user,Model model) {
		
		Integer id =userService.saveUser(user);
		model.addAttribute("message", "User '"+id+"' Successfully created..!");
		return "UserRegister";
	}
	
	//#03. Show Login page
	@GetMapping("/login")
	public String showLogin() {
		return "UserLogin";
	}
	
	
}
