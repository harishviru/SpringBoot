package com.har.journey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/data")
public class ProductController {

	
	  @RequestMapping("/data")
	  public String showProdData() {
		return "Home"; 
	  } 
}
