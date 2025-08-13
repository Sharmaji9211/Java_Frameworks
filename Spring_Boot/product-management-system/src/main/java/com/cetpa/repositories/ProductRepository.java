package com.cetpa.repositories;

import java.util.List;

import com.cetpa.models.Product;

public interface ProductRepository 
{
	void persistObject(Product product);
	Product getRecord(int pid);
	void deleteRecord(Product product);
	void updateRecord(Product oproduct, Product nproduct);
	List<Product> getList();
}
