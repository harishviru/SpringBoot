package com.har.journey.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


// Please refer MyNotes.txt file 


@Controller
public class EmployeeController {

	

	  @GetMapping("/show")
	  public String showData(
			     //@RequestParam("eid") int id,
			     //@RequestParam int eid,
			     @RequestParam(value = "eid",required = false,defaultValue ="-1") int id,
			     //@RequestParam("ename") String ename,
			     @RequestParam(value="ename",required = false,defaultValue = "None") String ename,
			     @RequestParam("projs") List<String> projs,
			     Model model
			  ) {
		  
		   model.addAttribute("eid", id);
		   model.addAttribute("ename", ename);
		   model.addAttribute("projs", projs);
		  return "EmpData";
	  }
	
	
	
	
}
