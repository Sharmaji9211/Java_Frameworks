package com.cetpa.services;

import java.util.List;

import com.cetpa.models.Product;

public interface ProductService 
{
	void saveProduct(Product product);
	Product getProduct(int pid);
	void deleteProduct(int pid);
	void updateProduct(Product product);
	List<Product> getProducts();
}
