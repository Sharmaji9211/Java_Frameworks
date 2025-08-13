package com.shiva.service;

import java.util.List;

import com.shiva.model.Product;

public interface productService {

	void addProduct(Product product);

	List<Product> getProduct();

	Product getProductById(int pid);

	List<Product> getProductByName(String name);

	List<Product> getProductByLessThanPrice(int price);

	List<Product> getProductByGreaterThanPrice(int price);

	void deleteById(int pid);

	void updateProduct(Product product);

	void updateProductPartilly(Product productOld, Product productNew);


}
