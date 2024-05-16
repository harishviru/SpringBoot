package com.har.journey.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ErrorInfo> handleProductNotFoundException(ProductNotFoundException pnfe,HttpServletRequest request){
        String requestURI = request.getRequestURI();
		ErrorInfo errorInfo =new ErrorInfo(HttpStatus.NOT_FOUND.value(), pnfe.getMessage(), requestURI);
		return new ResponseEntity<ErrorInfo>(errorInfo, HttpStatus.NOT_FOUND);
	}
	
	
}
