package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	
	@GetMapping("/all")
	public ResponseEntity<String> getAllProducts(){
		System.out.println("----------------ProductController.getAllProducts()----------------------");
		return new ResponseEntity<String>("FROM ALL ", HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> saveProducts(){
		System.out.println("----------------ProductController.saveProducts()----------------------");
		return new ResponseEntity<String>("FROM SAVE ", HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateProducts(){
		System.out.println("----------------ProductController.updateProducts()----------------------");
		return new ResponseEntity<String>("FROM UPDATE ", HttpStatus.OK);
	}
	
	@DeleteMapping("/remove")
	public ResponseEntity<String> deleteProducts(){
		System.out.println("----------------ProductController.deleteProducts()----------------------");
		return new ResponseEntity<String>("FROM DELETE ", HttpStatus.OK);
	}
	@PatchMapping("/modify")
	public ResponseEntity<String> modifyProducts(){
		System.out.println("----------------ProductController.modifyProducts()----------------------");
		return new ResponseEntity<String>("FROM PATCH ", HttpStatus.OK);
	}
	
	
	

}
