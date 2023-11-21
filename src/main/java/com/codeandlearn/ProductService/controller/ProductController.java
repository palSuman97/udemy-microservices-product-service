package com.codeandlearn.ProductService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codeandlearn.ProductService.entity.Product;
import com.codeandlearn.ProductService.exception.CustomException;
import com.codeandlearn.ProductService.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
//	@PostMapping
//	public Product addProduct(@RequestBody Product product) {
//		
//		return productService.addProduct(product);
//	}
	
	//@PreAuthorize("hasAuthority('admin')")
	@PostMapping
	public List<Product> addProducts(@RequestBody List<Product> products) {
		
		return productService.addProducts(products);
	}
	
	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable("id") Long productId, @RequestBody Product product) {
		
		return productService.updateProduct(productId, product);
	}
	
	@GetMapping
	public List<Product> getProducts() {
		
		return productService.getProducts();
	}
	
	//@PreAuthorize("hasAuthority('admin') || hasAuthority('customer') || hasAuthority('SCOPE_internal')")
	@GetMapping("/{id}")
	public Product getProduct(@PathVariable("id") long productId) {
		 
		return productService.getProduct(productId); 
	}
	
	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable("id") long productId) {
		
		return productService.deleteProduct(productId);
	}
	
	@PutMapping("/reduceQuantity/{id}")
	public String reduceQuantiny(@PathVariable("id") long productId, @RequestParam("quantity") long ordered_quantity) throws CustomException {
		
		productService.reduceQuantity(productId, ordered_quantity);
		return "Order Placed Successfully :)";
	}
}
