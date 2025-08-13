package com.shiva.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.shiva.model.Product;

public interface productRepository extends JpaRepository<Product, Integer> {

	List<Product> findByName(String name);

	List<Product> findByPriceLessThan(int price);

	List<Product> findByPriceGreaterThan(int price);

	

}
