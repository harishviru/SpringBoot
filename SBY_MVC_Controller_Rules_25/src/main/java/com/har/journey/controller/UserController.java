package com.har.journey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

	  //@RequestMapping(value={"/home","/login","/logout"})
	  @RequestMapping({"/vhome","/login","/logout"})
	  public String showLogin() { 
	    return "UserLoginPage";
	  } 
	  
	  @RequestMapping(value="/phome",method={
		       RequestMethod.GET,
		       RequestMethod.POST
		  })
	  public  String showLogin2() { 
		    return "UserLoginPage";
	 } 
	
	  private void test() {
		  
	  }
	  
}
