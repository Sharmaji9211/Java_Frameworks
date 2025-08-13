package com.cetpa.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cetpa.models.Product;
import com.cetpa.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService 
{
	private ProductRepository productRepository;
	public ProductServiceImpl(ProductRepository productRepository)
	{
		this.productRepository=productRepository;
	}
	public void saveProduct(Product product) 
	{
		productRepository.persistObject(product);
	}
	public Product getProduct(int pid) 
	{
		return productRepository.getRecord(pid);
	}
	public void deleteProduct(int pid) 
	{
		Product product=productRepository.getRecord(pid);
		productRepository.deleteRecord(product);
	}
	public void updateProduct(Product nproduct) 
	{
		Product oproduct=productRepository.getRecord(nproduct.getPid());
		productRepository.updateRecord(oproduct,nproduct);
	}
	public List<Product> getProducts() 
	{
		return productRepository.getList();
	}
}
