package com.har.journey.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.har.journey.exception.ProductNotFoundException;
import com.har.journey.model.Product;
import com.har.journey.repo.ProductRepository;
import com.har.journey.serviceImp.ProductServiceImp;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

	private static final Logger LOG =LoggerFactory.getLogger(ProductServiceTest.class);

	
	@Mock
	private ProductRepository prodRepo;
	
	@InjectMocks
	private ProductServiceImp prodService;
	
	@Test
	public void testSaveProduct() {
		LOG.info("-----------START of testSaveProduct--------------------");
		Long prodId =120L;
		Product product =new Product(prodId,"AC", 40000.0, new Date(),0.0,0.0);
		when(prodRepo.save(product)).thenReturn(product);
		Long dbprodId =prodService.saveProduct(product);
		final ArgumentCaptor<Product> prodCaptor = ArgumentCaptor.forClass(Product.class);
        verify(prodRepo, times(1)).save(prodCaptor.capture());
        final Product capturedProduct = prodCaptor.getValue();
        
		assertEquals(prodId, dbprodId);
		assertEquals(((Double)4800.0), capturedProduct.getProdGst());
		assertEquals(((Double)8000.0), capturedProduct.getProdDisc());
		
		LOG.info("-----------END of testSaveProduct--------------------");
	}

	@Test
	public void testGetAllProducts() {
		LOG.info("-----------START of testGetAllProducts--------------------");
		Long prodId =120L;
		List<Product> prodList =List.of(new Product(prodId,"AC", 40000.0, new Date(),0.0,0.0));
		when(prodRepo.findAll()).thenReturn(prodList);
		List<Product> dbProdList =prodService.getAllProducts();
		
		assertTrue(dbProdList.size()>0);
		LOG.info("-----------END of testGetAllProducts--------------------");
	}

	@Test
	public void testGetProduct() {
		LOG.info("-----------START of testGetProduct--------------------");
		Long prodId =120L;
		Product product =new Product(prodId,"AC", 40000.0, new Date(),0.0,0.0);
	    doReturn(Optional.of(product)).when(prodRepo).findById(prodId);
	    
		Product dbProd =prodService.getProduct(prodId);
		assertTrue(dbProd.getProdId().equals(prodId));

		LOG.info("-----------END of testGetProduct--------------------");
	}

	@Test
	public void testDeleteProduct() {
		LOG.info("-----------START of testDeleteProduct--------------------");
		Long prodId =120L;
		Product product =new Product(prodId,"AC", 40000.0, new Date(),0.0,0.0);
	    doReturn(Optional.of(product)).when(prodRepo).findById(prodId);

        doNothing().when(prodRepo).delete(product);
		
        prodService.deleteProduct(prodId);
        
		final ArgumentCaptor<Product> prodCaptor = ArgumentCaptor.forClass(Product.class);
        verify(prodRepo, times(1)).delete(prodCaptor.capture());
        final Product capturedProduct = prodCaptor.getValue();

		assertEquals(product.getProdCode(),capturedProduct.getProdCode());

		
		LOG.info("-----------END of testDeleteProduct--------------------");
	}

	@Test
	public void testProductExist() {
		LOG.info("-----------START of testProductExist--------------------");
		Long prodId =120L;
		doReturn(true).when(prodRepo).existsById(prodId);
		
		assertEquals(true, prodService.productExist(prodId));
		
		LOG.info("-----------END of testProductExist--------------------");
	}

	@Test
	public void testUpdateProduct() {
		LOG.info("-----------START of testUpdateProduct--------------------");
		Long prodId =120L;
		Product product =new Product(prodId,"AC", 40000.0, new Date(),0.0,0.0);
		when(prodRepo.save(product)).thenReturn(product);
		
		prodService.updateProduct(product);
		final ArgumentCaptor<Product> prodCaptor = ArgumentCaptor.forClass(Product.class);
        verify(prodRepo, times(1)).save(prodCaptor.capture());
        final Product capturedProduct = prodCaptor.getValue();
        
		assertEquals(prodId, capturedProduct.getProdId());
		assertEquals(((Double)4800.0), capturedProduct.getProdGst());
		assertEquals(((Double)8000.0), capturedProduct.getProdDisc());
		
		LOG.info("-----------END of testUpdateProduct--------------------");
	}

	@Test
	public void testUpdateProdCodeById() {
		LOG.info("-----------START of testUpdateProdCodeById--------------------");
		Long prodId =120L;
		String prodCode ="ABC";
		doReturn(true).when(prodRepo).existsById(prodId);
	    when(prodRepo.updateProdCodeById(prodCode, prodId)).thenReturn(1);
	    prodService.updateProdCodeById(prodId, prodCode);
	    
	    verify(prodRepo, times(1)).updateProdCodeById(prodCode,prodId);
	    
	    doReturn(false).when(prodRepo).existsById(prodId);
        assertThrows(ProductNotFoundException.class, ()->{
        	prodService.updateProdCodeById(prodId, prodCode);
        });
		LOG.info("-----------END of testUpdateProdCodeById--------------------");
	}

}
