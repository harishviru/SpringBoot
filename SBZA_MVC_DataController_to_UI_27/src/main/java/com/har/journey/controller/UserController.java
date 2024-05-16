package com.har.journey.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.har.journey.model.User;


//#01 : Sending Data(Primitive Type,Object,Collection) from controller to UI (Using EL)

@Controller
public class UserController {

	
	@GetMapping("/show")
	public String showData(Model model) {
		System.out.println(" Model class Name : "+model.getClass().getName());
		
		// Here we adding data to Model
		// ---------------------Primitive Type-----------------
		model.addAttribute("id", 101);
		model.addAttribute("name", "Indu");
		model.addAttribute("rating", 3.3);
		
	  // ---------------------User (Object Type)-----------------
		User user =new User(101, "A", "Hyd");
		model.addAttribute("userObj",user);
		
       // ---------------------List (Collection Type)-----------------
        List<String> alphaList =List.of("A","B","C","D","E");
        model.addAttribute("alphaList", alphaList);

        List<User> userList=List.of(
        		new User(501, "M", "Hyd"),
        		new User(502, "N", "Chn"),
        		new User(503, "O", "Bng"),
        		new User(504, "P", "Vzg")
        		);
        model.addAttribute("userList", userList);
		
		return "UserDataPage";
	}
	
	
}
