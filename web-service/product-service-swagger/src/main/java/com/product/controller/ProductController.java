package com.product.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.model.Product;
import com.product.service.ProductService;

@RestController
public class ProductController 
{
	@Autowired private ProductService productService;
	
	/*@PostMapping("/add")
	public ResponseEntity<Product> addProduct(@RequestBody Product product)
	{
		productService.saveProduct(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(product);
	}*/
	@PostMapping
	public ResponseEntity<Product> addProduct(@RequestBody Product product)
	{
		productService.saveProduct(product);
		 URI location = URI.create("/products/" + product.getPid());
		 return ResponseEntity.created(location).body(product);
	}
	@GetMapping
	public ResponseEntity<List<Product>> getProducts()
	{
		List<Product> products=productService.getProductList();
		if(products.isEmpty())
			return ResponseEntity.noContent().build();	
		return ResponseEntity.ok(products);
	}
	@GetMapping("/{pid}")
	public ResponseEntity<Product> getProduct(@PathVariable int pid)
	{
		Product product=productService.getProduct(pid);
		if(product==null)
			return ResponseEntity.notFound().build();	
		return ResponseEntity.ok(product);
	}
	@GetMapping("/byname/{name}")
	public ResponseEntity<List<Product>> getProductsByName(@PathVariable String name)
	{
		List<Product> products=productService.getProductListByName(name);
		if(products.isEmpty())
			return ResponseEntity.notFound().build();	
		return ResponseEntity.ok(products);
	}
	@GetMapping("/price/less-than/{price}")
	public ResponseEntity<List<Product>> getProductsByPriceLessThan(@PathVariable int price)
	{
		List<Product> products=productService.getProductListByPriceLessThan(price);
		if(products.isEmpty())
			return ResponseEntity.notFound().build();	
		return ResponseEntity.ok(products);
	}
	@PutMapping("/{pid}")
	public ResponseEntity<Product> updateProduct(@PathVariable int pid,@RequestBody Product product)
	{
		Product productOld=productService.getProduct(pid);
		if(productOld==null)
			return ResponseEntity.notFound().build();
		product.setPid(pid);
		productService.updateProduct(product);
		return ResponseEntity.ok(product);
	}
	@PatchMapping("/{pid}")
	public ResponseEntity<Product> updateProductPartially(@PathVariable int pid,@RequestBody Product productNew)
	{
		Product productOld=productService.getProduct(pid);
		if(productOld==null)
			return ResponseEntity.notFound().build();
		productService.updateProductPartially(productOld,productNew);
		return ResponseEntity.ok(productOld);
	}
	@DeleteMapping("/{pid}")
	public ResponseEntity<Product> deleteProduct(@PathVariable int pid)
	{
		Product product=productService.getProduct(pid);
		if(product==null)
			return ResponseEntity.notFound().build();
		productService.deleteProduct(pid);
		return ResponseEntity.ok(product);
	}
}
