package com.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.product.model.Product;
import com.product.repository.ProductDao;

@Service
public class ProductServiceImpl implements ProductService 
{
	private ProductDao productDao;
	public ProductServiceImpl(ProductDao productDao) 
	{
		this.productDao = productDao;
	}
	public void saveProduct(Product product) 
	{
		productDao.save(product);
	}
	public List<Product> getProductList() 
	{
		return productDao.findAll();
	}
	public Product getProduct(int pid) 
	{
		return productDao.findById(pid).orElse(null);
	}
	public List<Product> getProductListByName(String name) 
	{
		return productDao.findByName(name);
	}
	public List<Product> getProductListByPriceLessThan(int price) 
	{
		return productDao.findByPriceLessThan(price);
	}
	public void updateProduct(Product product) 
	{
		productDao.save(product);
	}
	public void updateProductPartially(Product productOld, Product productNew) 
	{
		String name=productNew.getName();
		if(name!=null)
			productOld.setName(name);
		String brand=productNew.getBrand();
		if(brand!=null)
			productOld.setBrand(brand);
		int price=productNew.getPrice();
		if(price!=0)
			productOld.setPrice(price);
		productDao.save(productOld);
	}
	public void deleteProduct(int pid) 
	{
		productDao.deleteById(pid);
	}
}
