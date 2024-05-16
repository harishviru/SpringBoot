package com.har.journey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**  Front controller when exception comes ,It will follow order below
 *        i)Specific error page            .     <ERROR_CODE>.<jsp/html>     >  404.jsp
 *        ii)Range Specific error page                                       >  5xx.jsp
 *        iii)Looks Global page as                                             error.jsp
 * 
 * 
 */


@SpringBootApplication
public class SbzgMvcMiniProj33Application {

	public static void main(String[] args) {
		SpringApplication.run(SbzgMvcMiniProj33Application.class, args);
	}

}
