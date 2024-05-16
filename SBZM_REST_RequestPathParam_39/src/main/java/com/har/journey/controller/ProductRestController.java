package com.har.journey.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//#01
@RestController
public class ProductRestController {

	
	// URL :  http://localhost:8080/find/12
	/**    -----------Request URLs-------------------------------
               http://localhost:8080/find/102
               http://localhost:8080/find/ABC     (Bad Request,400)
               http://localhost:8080/find         (Not Found,404)
               http://localhost:8080/find/102/PEN (Not Found,404)
	 */
	@GetMapping("/find/{id}")
	public String showData(@PathVariable Integer id) {
		return "DATA id : "+id; 
	}
	
	// URL : http://localhost:8080/update/abc/xyz
	/**    -----------Request URLs-------------------------------
              http://localhost:8080/update/ABC/XYZ
              http://localhost:8080/update/XYZ/ABC
              http://localhost:8080/update/XYZ         (Not Found,404)
              http://localhost:8080/update/XYZ/AB/AB   (Not Found,404)
	 */
	@GetMapping("/update/{code}/{model}")
	public String updateInfo(@PathVariable String code,@PathVariable String model) {
		return "DATA code : "+code +"  , model :"+model; 
	}
}
