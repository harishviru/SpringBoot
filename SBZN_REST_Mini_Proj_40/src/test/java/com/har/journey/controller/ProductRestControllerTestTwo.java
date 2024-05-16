package com.har.journey.controller;

import java.util.Date;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.har.journey.model.Product;

//#02  (Approach 2 : Test using TestRestTemplate to call REST API)
//It is  also connecting with REAL Database

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)  // To generate RANDOM Port 
public class ProductRestControllerTestTwo {

	private static final Logger LOG =LoggerFactory.getLogger(ProductRestControllerTestTwo.class);

	@LocalServerPort      //To get port number
	private int port;
	
    private String baseURL;
    
    @Autowired
    private TestRestTemplate testRestTemp;
    
  
    
    @BeforeEach
    public  void setup() {
    	baseURL =String.format("http://localhost:%d/api/products", port);
    }
    
    @Test
	public void testGetAllProducts() throws Exception {
		LOG.info("--------------------START of testGetAllProducts() -------------------");

		ResponseEntity<Product[]> response = testRestTemp.getForEntity(baseURL,Product[].class);
		
		LOG.info("response code :{}",response.getStatusCodeValue());
		LOG.info("response     :{}", Arrays.asList(response.getBody()));
		
		//#04 validate/assert details
		Assertions.assertEquals(200, response.getStatusCodeValue());
		
		LOG.info("--------------------END of testGetAllProducts() -------------------");
	}
    @Test
    public void testGetProductById() throws Exception {
    	LOG.info("--------------------START of testGetProductById() -------------------");
    	
    	ResponseEntity<Product> response = testRestTemp.getForEntity(baseURL+"/{prodId}",Product.class,8);
    	
    	LOG.info("response code :{}",response.getStatusCodeValue());
    	LOG.info("response     :{}", response.getBody());
    	
    	//#04 validate/assert details
    	Assertions.assertEquals(200, response.getStatusCodeValue());
    	
    	LOG.info("--------------------END of testGetProductById() -------------------");
    }
    
    @Test
	public void testSaveProduct() throws Exception {
		LOG.info("--------------------START of testSaveProduct() -------------------");

		Product product =new Product("Luxary Bed", 89000.0, new Date());
		HttpHeaders headers = new HttpHeaders();   
	    headers.setContentType(MediaType.APPLICATION_JSON);
		//Prepare payload/body    > HttpEntity : Request + Headers
		HttpEntity<Product> request =new HttpEntity<Product>(product, headers);

		ResponseEntity<String> response = testRestTemp.postForEntity(baseURL, request, String.class);
	
		LOG.info("response code :{}", response.getStatusCodeValue());
		LOG.info("response     :{}", response.getBody());

		Assertions.assertEquals(200, response.getStatusCodeValue());
		
		LOG.info("--------------------END of testSaveProduct() -------------------");
	}
    
    
    @Test
	public void testUpdateProduct() throws Exception {
		LOG.info("-------------------- START of testUpdateProduct() -------------------");

		Product product =new Product("Luxary Bed V2", 98000.0, new Date());
		HttpHeaders headers = new HttpHeaders();   
	    headers.setContentType(MediaType.APPLICATION_JSON);
		//Prepare payload/body    > HttpEntity : Request + Headers
		HttpEntity<Product> request =new HttpEntity<Product>(product, headers);
		
		ResponseEntity<String> response = testRestTemp.exchange(baseURL+"/{prodId}",HttpMethod.PUT, request, String.class,14);

		LOG.info("response code :{}", response.getStatusCodeValue());
		LOG.info("response     :{}", response.getBody());

		Assertions.assertEquals(200, response.getStatusCodeValue());
		
		LOG.info("----------------------END of testUpdateProduct() -------------------");
	}
    
    
    @Test
	public void testDeleteProduct() throws Exception {
		LOG.info("--------------------START of testDeleteProduct() -------------------");

		testRestTemp.delete(baseURL+"/{prodId}",14);
		LOG.info("Deleted successfully ");

		LOG.info("--------------------END of testDeleteProduct() -------------------");
	}
	
}
