package com.har.journey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WishMessageController {

	
	//@RequestMapping(value="/wish",method = RequestMethod.GET)
	@RequestMapping(value="/wish")
	public String wishMsg() {
		return "Home";
	}
	
}
