package com.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.model.Product;

public interface ProductDao extends JpaRepository<Product,Integer> 
{
	List<Product> findByName(String name);
	List<Product> findByPriceLessThan(int price);
}
