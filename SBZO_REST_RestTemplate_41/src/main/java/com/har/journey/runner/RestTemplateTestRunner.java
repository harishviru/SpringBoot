package com.har.journey.runner;

import java.util.Arrays;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.har.journey.model.Product;

@Component
public class RestTemplateTestRunner implements CommandLineRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(RestTemplateTestRunner.class);

	@Autowired
	private RestTemplate restTemp;

	@Value("${service.base.url}")
	private String baseURL;

	public RestTemplateTestRunner() {
		LOGGER.debug("BaseURL is :{} ", baseURL);
	}
	// exchange(URL, HttpMethod,requestEntity?,responseType, path... uriVariables):ResponseEntity<responseType>

	@Override
	public void run(String... args) throws Exception {

		// testGetMethod_1();
		// testGetMethod_2();
		//testGetMethod_WithPathVariable_3();
		//testPostMethod_WithBody_4();
		//testPutMethod_WithBody_5();
		//testPatchMethod_6();
		  testDeleteMethod_7();
		
		System.exit(0);

	}

	// i)METHOD > GET ; ResponseEntity > ResponseEntity<String>
	public void testGetMethod_1() {
		LOGGER.info("-----------------START of testGetMethod_1------------------------------------");

		ResponseEntity<String> response = restTemp.getForEntity(baseURL, String.class);

		LOGGER.info("response status code :{} ", response.getStatusCode().value());
		LOGGER.info("response status :{} ", response.getStatusCode());
		LOGGER.info("response body :{} ", response.getBody());

		LOGGER.info("-----------------END of testGetMethod_1------------------------------------");
	}

	// ii)METHOD > GET ; ResponseEntity > ResponseEntity<Product[]>
	public void testGetMethod_2() {
		LOGGER.info("-----------------START of testGetMethod_2------------------------------------");

		// ResponseEntity<List> response = restTemp.getForEntity(baseURL, List.class);
		ResponseEntity<Product[]> response = restTemp.getForEntity(baseURL, Product[].class);

		Product[] prodBody = response.getBody();

		LOGGER.info("response status code :{} ", response.getStatusCode().value());
		LOGGER.info("response status :{} ", response.getStatusCode());
		LOGGER.info("response body :{} ", Arrays.asList(prodBody));

		LOGGER.info("-----------------END of testGetMethod_2------------------------------------");
	}

	// iii)METHOD > GET ; ResponseEntity > ResponseEntity<Product>
	public void testGetMethod_WithPathVariable_3() {
		LOGGER.info("-----------------START of testGetMethod_WithPathVariable_3------------------------------------");
		ResponseEntity<?> response = null;
		String URL = baseURL + "/{prodId}";
		try {
			response = restTemp.getForEntity(URL, Object.class, 1);
			LOGGER.info("response status code :{} ", response.getStatusCode().value());
			LOGGER.info("response status :{} ", response.getStatusCode());
			LOGGER.info("response body :{} ", response.getBody());
		} catch (Exception e) { 
			LOGGER.error("Exception In testGetMethod_WithPathVariable_3 :{}", e.getMessage());
		}

		LOGGER.info("-----------------END of testGetMethod_WithPathVariable_3------------------------------------");
	}
	// iv)METHOD > POST ; ResponseEntity > ResponseEntity<String>
	/**
	 *   Request--> HttpEntity = body + headers
         header --> HttpHeaders
         body  --> String/ClassType/Collection
	 */
	public void testPostMethod_WithBody_4() {
		LOGGER.info("-----------------START of testPostMethod_WithBody_4------------------------------------");
		ResponseEntity<String> response = null;
		try {
			
			 Product product =new Product("Watch", 20000.0, new Date());
			//Request Header
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			
			//Prepare payload/body    > HttpEntity : Request + Headers
			HttpEntity<Product> request =new HttpEntity<Product>(product, headers);
			
			response = restTemp.postForEntity(baseURL, request, String.class);
			LOGGER.info("response status code :{} ", response.getStatusCode().value());
			LOGGER.info("response status :{} ", response.getStatusCode());
			LOGGER.info("response body :{} ", response.getBody());
		} catch (Exception e) { 
			LOGGER.error("Exception In testGetMethod_WithBody_4 :{}", e.getMessage());
		}
		
		LOGGER.info("-----------------END of testPostMethod_WithBody_4------------------------------------");
	}
	// v)METHOD > PUT 
	/**
	 *   Request--> HttpEntity = body + headers
         header --> HttpHeaders
         body  --> String/ClassType/Collection
	 */
	public void testPutMethod_WithBody_5() {
		LOGGER.info("-----------------START of testPutMethod_WithBody_5------------------------------------");
		ResponseEntity<Product> response = null;
		final String URL                =baseURL+"/{prodId}";
		try {
			
			Product product =new Product("Gold Watch", 99000.0, new Date());
			//Request Header
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			
			//Prepare payload/body    > HttpEntity : Request + Headers
			HttpEntity<Product> request =new HttpEntity<Product>(product, headers);
			restTemp.put(URL, request, 7);
			LOGGER.info("Updated successfully");
			
			response = restTemp.getForEntity(URL, Product.class, 7);
			LOGGER.info("response status code :{} ", response.getStatusCode().value());
			LOGGER.info("response status :{} ", response.getStatusCode());
			LOGGER.info("response body :{} ", response.getBody());
			
		} catch (Exception e) { 
			LOGGER.error("Exception In testPutMethod_WithBody_5 :{}", e.getMessage());
		}
		
		LOGGER.info("-----------------END of testPutMethod_WithBody_5------------------------------------");
	}
	// vi)METHOD > PATCH ; ResponseEntity > ResponseEntity<String>
	public void testPatchMethod_6() {
		LOGGER.info("-----------------START of testPatchMethod_6------------------------------------");
		ResponseEntity<Product> response = null;
		final String URL                =baseURL+"/{prodId}/{prodCode}";
		try {
			
			//String patchResponse = restTemp.patchForObject(URL, null, String.class, 7,"Wrist Watch Gold");
			ResponseEntity<String> resp = restTemp.exchange(URL, HttpMethod.PATCH,null, String.class,7,"Wrist_Watch_Gold");
			LOGGER.info("patchResponse : {}",resp);
			
			response = restTemp.getForEntity(baseURL+"/{prodId}", Product.class, 7);
			LOGGER.info("response status code :{} ", response.getStatusCode().value());
			LOGGER.info("response status :{} ", response.getStatusCode());
			LOGGER.info("response body :{} ", response.getBody());
			
		} catch (Exception e) { 
			LOGGER.error("Exception In testPatchMethod_6 :{}", e.getMessage());
		}
		
		LOGGER.info("-----------------END of testPatchMethod_6------------------------------------");
	}
	
	// vii)METHOD > DELETE ; ResponseEntity > ResponseEntity<String>
	public void testDeleteMethod_7() {
		LOGGER.info("-----------------START of testDeleteMethod_7------------------------------------");
		ResponseEntity<String> response = null;
		final String URL                =baseURL+"/{prodId}";
		try {
			
			  restTemp.delete(URL,5);
			  LOGGER.info("Deleted successfully ");
			  response = restTemp.exchange(URL, HttpMethod.DELETE,null, String.class,6);
			 LOGGER.info("response : {}",response);
			
			LOGGER.info("response status code :{} ", response.getStatusCode().value());
			LOGGER.info("response status :{} ", response.getStatusCode());
			LOGGER.info("response body :{} ", response.getBody());
			
		} catch (Exception e) { 
			LOGGER.error("Exception In testDeleteMethod_7 :{}", e.getMessage());
		}
		
		LOGGER.info("-----------------END of testDeleteMethod_7------------------------------------");
	}

}
