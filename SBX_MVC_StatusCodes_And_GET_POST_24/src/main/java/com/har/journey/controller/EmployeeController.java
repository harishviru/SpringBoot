package com.har.journey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/** If we enter URL: /showe (GET) in browser, display---> HomePage.jsp
        HomePage.jsp Should contain one Link and HTML Form
           On click Link : View All , make Request: /view (GET), that should display: DataPage.jsp
           On click Form Submit, make Request: /register (POST), should display: SuccessPage.jsp
*/

@Controller
public class EmployeeController {

	
	/** If we enter URL : /showe (GET) in browser,
	 *    display --> HomePage.jsp
	 * 
	 * 
	 */
	@RequestMapping("/showe")
	public String showData() {
		return "HomePage";
	}
	
	/** On click Link : View All , make Request: /view (GET), 
	 * that should display: DataPage.jsp
	 * 
	 */
	@RequestMapping("/view")
	public String showView() {
		return "DataPage";
	}
	
	/**
	 * On click Form Submit, make Request: /register (POST), 
	 * should display: SuccessPage.jsp
	 * 
	 */
	@RequestMapping(value="/register",method = RequestMethod.POST)
	public String showRegister() {
		return "SuccessPage";
	}
	
	
	
	
	
}
