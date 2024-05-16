package com.har.journey.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.har.journey.exception.ProductNotFoundException;
import com.har.journey.model.Product;
import com.har.journey.service.ProductService;
import com.har.journey.util.ProductUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/products")
@Api(description = "This is Product API")
public class ProductRestController {

	private static final Logger LOG =LoggerFactory.getLogger(ProductRestController.class);
	
	
	@Autowired
	private ProductService prodService;
	
	
	//#01. Save Product
	@PostMapping
	@ApiOperation("This is used to save the product")
	public ResponseEntity<String> saveProduct(@RequestBody Product product){
		ResponseEntity<String> resp =null;
		LOG.info("--------------------START of saveProduct() -------------------");
		try {
			Long prodId =prodService.saveProduct(product);
			resp  = new ResponseEntity<String>("Product '"+prodId+"' saved !",HttpStatus.OK); //200 -OK. 
			LOG.info("Product {} saved !",prodId);
		}catch (Exception e) {
			resp  = new ResponseEntity<String>("Unable to Save the product..!",HttpStatus.INTERNAL_SERVER_ERROR);
			LOG.error("Unable to Save the product..! error is {}",e.getMessage());
            e.printStackTrace();
		}
		LOG.info("--------------------END of saveProduct() -------------------");
		return resp;
	}
	
	
	//#02. Get All Products
	@GetMapping
	@ApiOperation("This is used to get all products Info")
	public ResponseEntity<?> getAllProducts(){
		ResponseEntity<?> prodResp =null;
		LOG.info("--------------------START of getAllProducts() -------------------");
		try {
			List<Product> prodList =prodService.getAllProducts();
			              prodResp =new ResponseEntity<List<Product>>(prodList,HttpStatus.OK);
		}catch (Exception e){
			prodResp  = new ResponseEntity<String>("Unable to get the products..!",HttpStatus.INTERNAL_SERVER_ERROR);
			LOG.error("Unable to get the products..! error is {}",e.getMessage());
            e.printStackTrace();
		}
		LOG.info("--------------------END of getAllProducts() -------------------");
		return prodResp;
	}
	
	//#03. Get One Product By ProdId
	@GetMapping("/{prodId}")
	@ApiOperation("This is used to get product by prodId")
	public ResponseEntity<?> getProductById(@PathVariable Long prodId){
		ResponseEntity<?> prodResp =null;
		LOG.info("--------------------START of getAllProductById() ------------------- prodId :{}",prodId);
		try{
			Product product =prodService.getProduct(prodId);
			prodResp        =new ResponseEntity<Product>(product,HttpStatus.OK);
		}catch (ProductNotFoundException pnfe) {
			  throw pnfe;
		}catch (Exception e) {
			prodResp  = new ResponseEntity<String>("Unable to get the product..!",HttpStatus.INTERNAL_SERVER_ERROR);
			LOG.error("Unable to get the product..prodId :{}, error :{}",prodId,e.getMessage());
            e.printStackTrace();
		}
		LOG.info("--------------------END of getAllProductById() ------------------- ");
		return prodResp;
	}
	
	//#04. Get One Product By ProdId
    @DeleteMapping("/{prodId}")
	@ApiOperation("This is used to delete product by prodId")
	public ResponseEntity<String> deleteProduct(@PathVariable Long prodId){
		ResponseEntity<String> pResp =null;
		LOG.info("--------------------START of deleteProduct() ------------------- prodId :{}",prodId);
    	try {
    		prodService.deleteProduct(prodId);
    		pResp        =new ResponseEntity<String>("Product '"+prodId+"' delete successfully",HttpStatus.OK);
			LOG.info("Product '{}' delete successfully",prodId);
    	}catch (ProductNotFoundException  pnfe) {
			throw pnfe;
		}catch (Exception e) {
    		pResp  = new ResponseEntity<String>("Unable to delete the product with "+prodId,HttpStatus.INTERNAL_SERVER_ERROR);
			LOG.error("Unable to delete the product with :{}, error :{}",prodId,e.getMessage());
            e.printStackTrace();
		}
		LOG.info("--------------------END of deleteProduct() -------------------");
		return pResp;
	}
	
    //#05. Update Product based on ProdId
    @PutMapping("/{prodId}")
	@ApiOperation("This is used to update product by prodId")
	public ResponseEntity<String> updateProduct(@PathVariable Long prodId,@RequestBody Product product){
    	ResponseEntity<String> resp =null;
		LOG.info("--------------------START of updateProduct() ------------------- prodId :{}",prodId);
    	try {
    		Product dbProduct =prodService.getProduct(prodId);
    		ProductUtil.copyProduct(dbProduct, product);   //copy non-null values
    		//Finally update the product 
    		prodService.updateProduct(dbProduct);
    		resp        =new ResponseEntity<String>("Product '"+prodId+"' updated successfully",HttpStatus.OK);
			LOG.info("Product '{}' updated successfully",prodId);
    	}catch (ProductNotFoundException pnfe) {
			throw pnfe;
		}catch (Exception e) {
			resp  = new ResponseEntity<String>("Unable to update the product with "+prodId,HttpStatus.INTERNAL_SERVER_ERROR);
			LOG.error("Unable to update the product with :{}, error :{}",prodId,e.getMessage());
            e.printStackTrace();
		}
		LOG.info("--------------------END of updateProduct() -------------------");
		return resp;
    }
		
    //#06. Update Product Code based on ProdId
    @PatchMapping("/{prodId}/{prodCode}")
	@ApiOperation("This is used to update product code by prodId")
	public ResponseEntity<String> updateProdCodeById(@PathVariable Long prodId,@PathVariable String prodCode){
    	ResponseEntity<String> resp =null;
		LOG.info("--------------------START of updateProdCodeById() ------------------- prodId :{}",prodId);
    	try {
    		prodService.updateProdCodeById(prodId, prodCode);
    		resp        =new ResponseEntity<String>("Product code '"+prodId+"' updated successfully",HttpStatus.OK);
			LOG.info("Product code {}, with '{}' updated successfully",prodCode,prodId);
    	}catch (ProductNotFoundException pnfe) {
			throw pnfe;
		}catch (Exception e) {
			resp  = new ResponseEntity<String>("Unable to update the prodCode with "+prodId,HttpStatus.INTERNAL_SERVER_ERROR);
			LOG.error("Unable to update the prodCode with :{}, error :{}",prodId,e.getMessage());
            e.printStackTrace();
		}
		LOG.info("--------------------END of updateProdCodeById() -------------------");
    	return resp;
    }

	
	
}
