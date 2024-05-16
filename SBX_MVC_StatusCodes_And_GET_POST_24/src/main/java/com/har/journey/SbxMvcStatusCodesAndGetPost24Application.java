package com.har.journey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**  1) Expalins about response status code like 200 ,404,405,500
 *   2) Expalins about GET,POST methods with example
 * 
 *  #01:
    if We enter below URL's and result :
	      i)http://localhost:9090/abc          : 404 (NOT FOUND)
	     ii)http://localhost:9090/find         : 405 (Method Not Allowed)  
	    iii)http://localhost:9090/showc        : 404 (NOT FOUND) [Here contact page is not found]
	     iv)http://localhost:9090/showd        : 500 (INTERNAL SERVER ERROR)
	      v)http://localhost:9090/show         : 200 (OK) 
	     vi)http://localhost:9090/             : 404 (NOT FOUND)
 
     #02:
      If we enter URL: /show (GET) in browser, display---> HomePage.jsp

       HomePage.jsp Should contain one Link and HTML Form
       On click Link : View All , make Request: /view (GET), that should display: DataPage.jsp

       On click Form Submit, make Request: /register (POST), should display: SuccessPage.jsp
 
 * 
 */

@SpringBootApplication
public class SbxMvcStatusCodesAndGetPost24Application {

	public static void main(String[] args) {
		SpringApplication.run(SbxMvcStatusCodesAndGetPost24Application.class, args);
	}

}
