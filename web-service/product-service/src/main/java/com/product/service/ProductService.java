package com.product.service;

import java.util.List;

import com.product.model.Product;

public interface ProductService 
{
	void saveProduct(Product product);
	List<Product> getProductList();
	Product getProduct(int pid);
	List<Product> getProductListByName(String name);
	List<Product> getProductListByPriceLessThan(int price);
	void updateProduct(Product product);
	void updateProductPartially(Product productOld, Product product);
	void deleteProduct(int pid);
}
