package com.har.journey.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**  Explian about Common HTTP Status Codes:
 *          i) 200 (OK) 
 *          ii)404 (NOT FOUND)
 *          iii)405 (Method Not Allowed)
 *          iv)500 (INTERNAL SERVER ERROR)
 */

@Controller
public class StudentController {

	/** if We enter below URL's and result :
	 *      i)http://localhost:9090/abc          : 404 (NOT FOUND)
	 *     ii)http://localhost:9090/find         : 405 (Method Not Allowed)  
	 *    iii)http://localhost:9090/showc        : 404 (NOT FOUND) [Here contact page is not found]
	 *     iv)http://localhost:9090/showd        : 500 (INTERNAL SERVER ERROR)
	 *      v)http://localhost:9090/show         : 200 (OK) 
	 *     vi)http://localhost:9090/             : 404 (NOT FOUND)
	 */
	
	
	//@RequestMapping(value="/show",method = RequestMethod.GET)
	 @RequestMapping("/show")
	 public String showA() {
		return "Home";
	}
	 
	 @RequestMapping(value ="/find",method = RequestMethod.POST)
	 public String showB() {
		 return "Home";
	 }
	 @RequestMapping(value ="/showc")
	 public String showC() {
		 return "contact";    // Here contact page is not defined/created
	 }
	
	 @RequestMapping(value ="/showd")
	 public String showD() {
		 if(new Random().nextInt(10)<11) {
			 throw new RuntimeException("Dummy Exp");// 500 (INTERNAL SERVER ERROR)
		 }
		 return "Home";
	 }
	
}
