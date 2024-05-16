package com.har.journey.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.har.journey.model.Product;
import com.har.journey.service.ProductService;

//#03 : Approach 3: Test using Mockito 

@ExtendWith(MockitoExtension.class)   //Enabling/Register Mockito Annotations
public class ProductRestControllerTestThree {

	private static final Logger LOG =LoggerFactory.getLogger(ProductRestController.class);

	
	@InjectMocks
	private ProductRestController prodRestController;
	
	@Mock
	private ProductService prodService;
	
	@Captor
	private ArgumentCaptor<Product> argCaptor;
	
	@Test
	public void  testSaveProduct() {
		LOG.info("--------------------START of testSaveProduct() -------------------");

		Product product =new Product("Tvs", 128000.0, new Date());
		when(prodService.saveProduct(product)).thenReturn(120L);
		ResponseEntity<String> response = prodRestController.saveProduct(product);
	
		assertEquals(HttpStatus.OK.value(), response.getStatusCodeValue());
		assertTrue(response.getBody().contains("saved"));
		LOG.info("--------------------END of testSaveProduct() -------------------");
	}
	
	@Test
	public void testGetAllProducts() {
		LOG.info("--------------------START of testGetAllProducts() -------------------");
		List<Product> prodList =List.of(		
				new Product("Tvs", 128000.0, new Date()),
				new Product("Refrigerator", 78000.0, new Date())
				);
		
		when(prodService.getAllProducts()).thenReturn(prodList);

		ResponseEntity<?> response = prodRestController.getAllProducts();

		assertEquals(HttpStatus.OK.value(), response.getStatusCodeValue());
		assertTrue(((List)response.getBody()).size()>=2);

		LOG.info("--------------------END of testGetAllProducts() -------------------");
	}
	@Test
	public void testGetProductById() {
		LOG.info("--------------------START of testGetProductById() -------------------");
		Long prodId =120L;
		Product product =new Product(prodId,"Tvs", 128000.0, new Date(),12800.0,25600.0);
		
		when(prodService.getProduct(prodId)).thenReturn(product);
		
		ResponseEntity<?> response = prodRestController.getProductById(prodId);
		 Product prod =(Product) response.getBody();
		
		assertEquals(HttpStatus.OK.value(), response.getStatusCodeValue());
		assertEquals(prodId,prod.getProdId());
		
		LOG.info("--------------------END of testGetProductById() -------------------");
	}
	@Test
	public void testDeleteProduct() {
		LOG.info("--------------------START of testGetProductById() -------------------");
		Long prodId =120L;
		
		doNothing().when(prodService).deleteProduct(prodId);
		
		ResponseEntity<?> response = prodRestController.deleteProduct(prodId);
		
		assertEquals(HttpStatus.OK.value(), response.getStatusCodeValue());
		assertEquals("Product '120' delete successfully",response.getBody().toString());
		verify(prodService).deleteProduct(prodId);
		LOG.info("--------------------END of testGetProductById() -------------------");
	}
	@Test
	public void testUpdateProduct() {
		LOG.info("--------------------START of testUpdateProduct() -------------------");
		Long prodId =120L;
		Product dBproduct =new Product(prodId,"Tvs", 128000.0, new Date(),12800.0,25600.0);
		when(prodService.getProduct(prodId)).thenReturn(dBproduct);
		
		Product inProduct =new Product(prodId,"AC", 34000.0, new Date(),3400.0,6800.0);
		
		ResponseEntity<?> response = prodRestController.updateProduct(prodId,inProduct);
		
		assertEquals(HttpStatus.OK.value(), response.getStatusCodeValue());
		assertEquals("Product '120' updated successfully",response.getBody().toString());
        verify(prodService, times(1)).updateProduct(argCaptor.capture());

        final Product capturedProduct = argCaptor.getValue();
		assertEquals("AC", capturedProduct.getProdCode());

		LOG.info("--------------------END of testUpdateProduct() -------------------");
	}
	@Test
	public void testUpdateProdCodeById() {
		LOG.info("--------------------START of testUpdateProdCodeById() -------------------");
		Long prodId    = 120L;
		String prodCode= "Tab";
		doNothing().when(prodService).updateProdCodeById(prodId,prodCode);
		
		ResponseEntity<String> response = prodRestController.updateProdCodeById(prodId,prodCode);
		
		assertEquals(HttpStatus.OK.value(), response.getStatusCodeValue());
		assertEquals("Product code '120' updated successfully",response.getBody().toString());
		verify(prodService, times(1)).updateProdCodeById(prodId,prodCode);
			
		LOG.info("--------------------END of testUpdateProdCodeById() -------------------");
	}
	
	
	
}
