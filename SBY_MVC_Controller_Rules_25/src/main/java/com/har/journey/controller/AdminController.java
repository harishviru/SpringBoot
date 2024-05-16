package com.har.journey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*6)   We can even provide URL at controller class level using @RequestMapping
       (but not method type).
       It is recomanded if multiple controller are exist in application.
*/

@Controller
@RequestMapping("/admin")
public class AdminController {

	
	@RequestMapping("/register")
	//@RequestMapping("/adminregister")
	public String showReg() {
		return "AdminRegister";
	}
}
