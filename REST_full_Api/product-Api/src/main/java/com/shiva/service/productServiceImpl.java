package com.shiva.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shiva.model.Product;
import com.shiva.repository.productRepository;

@Service
public class productServiceImpl implements productService {
	private productRepository productRepository;

	public productServiceImpl(com.shiva.repository.productRepository productRepository) {
		this.productRepository = productRepository;
	}

	public void addProduct(Product product) {
		productRepository.save(product);
	}

	public List<Product> getProduct() {

		return productRepository.findAll();
	}

	public Product getProductById(int pid) {

		return productRepository.findById(pid).orElse(null);
	}

	public List<Product> getProductByName(String name) {

		return productRepository.findByName(name);
	}

	public List<Product> getProductByLessThanPrice(int price) {
		return productRepository.findByPriceLessThan(price);
	}

	public List<Product> getProductByGreaterThanPrice(int price) {
		return productRepository.findByPriceGreaterThan(price);
	}

	public void deleteById(int pid) {
		productRepository.deleteById(pid);

	}

	public void updateProduct(Product product) {
		productRepository.save(product);
	}

	public void updateProductPartilly(Product productOld, Product productNew) {
		String name = productNew.getName();
		String brand = productNew.getBrand();
		int price = productNew.getPrice();

		if (name != null) {
			productOld.setName(name);
		}
		if (brand != null) {
			productOld.setBrand(brand);
		}
		if (price != 0) {
			productOld.setPrice(price);
		}

	}

}
