package com.har.journey.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	
	@GetMapping("/home")
	public String showHome() {
		return "HomePage";
	}
	
	@GetMapping("/admin")
	public String showAdmin() {
		return "AdminPage";
	}
	
	@GetMapping("/emp")
	public String showEmp() {
		return "EmployeePage";
	}
	
	@GetMapping("/common")
	public String showCommon() {
		return "CommonPage";
	}
	
	@GetMapping("/profile")
	public String showProfile(Principal principal ,Model model) {
		model.addAttribute("userNameObj", principal.getName());
		return "ProfilePage";
	}
	
	
	
	@GetMapping("/denied")
	public String showDenied() {
		return "DeniedPage";
	}
	
	
}
