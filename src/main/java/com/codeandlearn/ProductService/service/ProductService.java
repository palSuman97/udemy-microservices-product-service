package com.codeandlearn.ProductService.service;

import java.util.List;

import com.codeandlearn.ProductService.entity.Product;
import com.codeandlearn.ProductService.exception.CustomException;

public interface ProductService {

	Product addProduct(Product product);

	List<Product> addProducts(List<Product> products);

	Product updateProduct(Long productId, Product product);

	List<Product> getProducts();

	Product getProduct(long productId);

	String deleteProduct(long productId);

	void reduceQuantity(long productId, long ordered_quantity) throws CustomException;

}
