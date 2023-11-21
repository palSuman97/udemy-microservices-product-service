package com.codeandlearn.ProductService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeandlearn.ProductService.entity.Product;
import com.codeandlearn.ProductService.exception.CustomException;
import com.codeandlearn.ProductService.exception.CustomExceptionExternal;
import com.codeandlearn.ProductService.exception.ResourceNotFoundException;
import com.codeandlearn.ProductService.repository.ProductRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product addProduct(Product product) {
		
		return productRepository.save(product);
	}

	@Override
	public List<Product> addProducts(List<Product> products) {
		
		return productRepository.saveAll(products);
	}

	@Override
	public Product updateProduct(Long productId, Product product) {
		
		Product updateProduct= productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("ProductId: "+ productId +" not Found", "PRODUCT_NOT_FOUND"));
		
		log.info("product: {}", product);
		
		if(product.getProductName()!=null)
			updateProduct.setProductName(product.getProductName());
		if(product.getPrice()!=0)
			updateProduct.setPrice(product.getPrice());
		if(product.getQuantity()!=0)
			updateProduct.setQuantity(product.getQuantity());
		
		return productRepository.save(updateProduct);
		
	}

	@Override
	public List<Product> getProducts() {
		
		return productRepository.findAll();
	}

	@Override
	public Product getProduct(long productId) {
		
		return productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("ProductId: "+ productId +" not Found", "PRODUCT_NOT_FOUND"));
	}

	@Override
	public String deleteProduct(long productId) {
		
		Product product= productRepository.findById(productId)
		.orElseThrow(() -> new ResourceNotFoundException("ProductId: "+ productId +" not Found","PRODUCT_NOT_FOUND"));
		
		productRepository.delete(product);
		
		return "ProductId: "+productId+" is deleted Successfully :)";
	}

	@Override
	public void reduceQuantity(long productId, long ordered_quantity) throws CustomException,CustomExceptionExternal {
		
		log.info("product id: {}", productId);
		
		Product ordered_product= productRepository.findById(productId)
				.orElseThrow(() -> new CustomException("ProductId: "+ productId +" not Found"));
		
		if(ordered_quantity > ordered_product.getQuantity())
			throw new CustomExceptionExternal("Product does not have Sufficient Quantity","INSUFFICIENT_QUANTITY", 500);
		else {
			ordered_product.setQuantity(ordered_product.getQuantity()-ordered_quantity);
			productRepository.save(ordered_product);
		}
	}

}
