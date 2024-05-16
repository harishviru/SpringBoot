package com.har.journey.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**  
 => ****Now, for every operation (GET/POST/PUT/DELETE)

 1) Create one Dummy Request(HttpServletRequest)

 2) Execute Request (using Mocked MVC Environment) and Get Result

 3) Read Response (HttpServletResponse) given by Mocked MVC Environment.

 4) Validate/Assert Actual data with Expected data.
   (must check status, Response Body, Content-Type..etc)
 * 
 */


//#01 (Approach 1 :Test using MockMvc to perform REST calls)

//It is connecting with REAL Database
@SpringBootTest(webEnvironment = WebEnvironment.MOCK) //Create Dummy Spring container with basic setup 
@AutoConfigureMockMvc                                 //Activate AutoConfiguration for MVC application setup.
@TestPropertySource("classpath:application-test.properties")                    // Load Properties file for Test Environment (if any specific file).
class ProductRestControllerTest {

	
	private static final Logger LOG =LoggerFactory.getLogger(ProductRestControllerTest.class);

	
	@Autowired
	private MockMvc mockMvc;
	
	private static final String BASE_URL ="/api/products";
	
	
	@Test
	public void testGetAllProducts() throws Exception {
		LOG.info("--------------------START of testGetAllProducts() -------------------");

		//#01. Create Dummy HTTP Request
		MockHttpServletRequestBuilder mockHttpServletReq = MockMvcRequestBuilders.get(BASE_URL);
		
		//#02 .Execute the request and get result
		MvcResult mvcResult = mockMvc.perform(mockHttpServletReq).andReturn();
		
		//#03 Read the response from result
		MockHttpServletResponse response = mvcResult.getResponse();
		
		LOG.info("response code :{}",response.getStatus());
		LOG.info("response     :{}",response.getContentAsString());
		
		//#04 validate/assert details
		Assertions.assertEquals(200, response.getStatus());
		
		LOG.info("--------------------END of testGetAllProducts() -------------------");
	}

	
	@Test
	public void testGetProductById() throws Exception {
		LOG.info("--------------------START of testGetProductById() -------------------");

		//#01. create Dummy HTTP Request
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.get(BASE_URL+"/{prodId}", 9);
		
		//#02. Execute request and get Result
		MvcResult mcMvcResult = mockMvc.perform(mockRequest).andReturn();
		
		//#03. Read the response from result
		MockHttpServletResponse response = mcMvcResult.getResponse();
		
		LOG.info("response code :{}",response.getStatus());
		LOG.info("response     :{}",response.getContentAsString());
		
		//#04 validate/assert details
		Assertions.assertEquals(200, response.getStatus());
		
		LOG.info("--------------------START of testGetProductById() -------------------");
		
	}
	
	
	@Test
	public void testSaveProduct() throws Exception {
		
		LOG.info("--------------------START of testSaveProduct() -------------------");

		//#01. create Dummy HTTP Request
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
				                                                   .post(BASE_URL)
				                                                   .content("{ \"prodCode\": \"AC\", \"prodCost\": 560000.0, \"prodExpDt\": \"1-12-2029\" }")
				                                                   .contentType(MediaType.APPLICATION_JSON);
		// #02. Execute request and get Result
		MvcResult mcMvcResult = mockMvc.perform(mockRequest).andReturn();

		// #03. Read the response from result
		MockHttpServletResponse response = mcMvcResult.getResponse();

		LOG.info("response code :{}", response.getStatus());
		LOG.info("response     :{}", response.getContentAsString());

		// #04 validate/assert details
		Assertions.assertEquals(200, response.getStatus());
		
		LOG.info("--------------------END of testSaveProduct() -------------------");
	}
	
	@Test
	public void testDeleteProduct() throws Exception {
		LOG.info("--------------------START of testDeleteProduct() -------------------");

		//#01. create Dummy HTTP Request
		MockHttpServletRequestBuilder mockRequest= MockMvcRequestBuilders.delete(BASE_URL+"/{prodId}",11);
		
		// #02. Execute request and get Result
		MvcResult mcMvcResult = mockMvc.perform(mockRequest).andReturn();

		// #03. Read the response from result
		MockHttpServletResponse response = mcMvcResult.getResponse();

		LOG.info("response code :{}", response.getStatus());
		LOG.info("response     :{}", response.getContentAsString());

		// #04 validate/assert details
		Assertions.assertEquals(200, response.getStatus());

		LOG.info("--------------------END of testDeleteProduct() -------------------");
	}
	
	@Test
	public void testUpdateProduct() throws Exception {
		LOG.info("-------------------- START of testUpdateProduct() -------------------");
		

		//#01. create Dummy HTTP Request
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
				                                                   .put(BASE_URL+"/{prodId}",10)
				                                                   .content("{ \"prodCode\": \"Refrigerator\", \"prodCost\": 760000.0, \"prodExpDt\": \"1-12-2031\" }")
				                                                   .contentType(MediaType.APPLICATION_JSON);
		// #02. Execute request and get Result
		MvcResult mcMvcResult = mockMvc.perform(mockRequest).andReturn();

		// #03. Read the response from result
		MockHttpServletResponse response = mcMvcResult.getResponse();

		LOG.info("response code :{}", response.getStatus());
		LOG.info("response     :{}", response.getContentAsString());

		// #04 validate/assert details
		Assertions.assertEquals(200, response.getStatus());
		
		LOG.info("----------------------END of testUpdateProduct() -------------------");

	}
	
	
	@Test
	public void testUpdateProdCodeById() throws Exception {
		LOG.info("--------------------START of testUpdateProdCodeById() -------------------");

		//#01. create Dummy HTTP Request
		MockHttpServletRequestBuilder mockRequest= MockMvcRequestBuilders.patch(BASE_URL+"/{prodId}/{prodCode}",10,"Samsung Refrigerator");
		
		// #02. Execute request and get Result
		MvcResult mcMvcResult = mockMvc.perform(mockRequest).andReturn();

		// #03. Read the response from result
		MockHttpServletResponse response = mcMvcResult.getResponse();

		LOG.info("response code :{}", response.getStatus());
		LOG.info("response     :{}", response.getContentAsString());

		// #04 validate/assert details
		Assertions.assertEquals(200, response.getStatus());

		LOG.info("--------------------END of testUpdateProdCodeById() -------------------");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}










