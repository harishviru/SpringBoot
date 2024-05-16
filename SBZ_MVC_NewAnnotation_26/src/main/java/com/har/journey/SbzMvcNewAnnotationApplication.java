package com.har.journey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** i)    New and Short Annotations. 
        -------------------------
 GET     : @GetMapping("/path")
 POST    : @PostMapping("/path")
 PUT     : @PutMapping("/path")
 DELETE  : @DeleteMapping("/path")
 PATCH   : @PatchMapping("/path")

 @GetMapping("/path") ==> @RequestMapping(value="/path",method=RequestMethod.GET)
 
  ii) Spring boot, web server default port number is : 8080.
   HTTP Default port number is : 80

if we set port number as 80 then need not to provide 80 in URL 
ie
  http://localhost:80/myapp/home
  http://localhost/myapp/home
Note : we can set port number like server.port=80
 
 iii) Setting Context Path by using
   In Application properties >   server.servlet.context-path: /myapp
 
     URL : http://localhost:9090/myapp/home
 
 *    
 */


@SpringBootApplication
public class SbzMvcNewAnnotationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbzMvcNewAnnotationApplication.class, args);
	}

}
