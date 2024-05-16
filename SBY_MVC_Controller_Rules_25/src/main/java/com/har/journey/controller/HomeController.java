package com.har.journey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping(value = "/home")
	public String showA() {
		return "Home";
	}
	
  /**
   *   Caused by: java.lang.IllegalStateException: Ambiguous mapping. Cannot map 'homeController' method 
             com.har.journey.controller.HomeController#showB() to { [/register]}: 
             There is already 'homeController' bean method com.har.journey.controller.HomeController#showA() mapped.
   */
	//@RequestMapping(value = "/home")                               // For #3 >  URL is case-sensitive, Path should never be duplicated.   
	//@RequestMapping(value = "/home",method = RequestMethod.POST)  // For #4  > Same URL(PATH) can be used at multiple method, but Combination of URL+MethodType must be unique.
	public String showB() {
		return "Home";
	}
	
	@RequestMapping   // For #5   > If we do not specify any method Type then default is GET type.
	                  //For  #8   > We can even define Controller#method without path, then default is set to '/'
	public String showC() {
		return "Home";
	}
	
	
	
}
