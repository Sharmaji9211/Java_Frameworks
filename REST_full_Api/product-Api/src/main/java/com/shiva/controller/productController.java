package com.shiva.controller;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.shiva.model.Product;
import com.shiva.service.productService;
@RestController
public class productController 
{

	 private productService productService;

	 public productController(com.shiva.service.productService productService) {
		this.productService = productService;
	 }	 
	 @PostMapping("/add")
	 public Product addProduct(@RequestBody Product product) {
		 productService.addProduct(product);
		 return product;
	 }
	 @GetMapping
	 public ResponseEntity<List<Product>> getProduct(){ 
		List<Product> list= productService.getProduct();
		if(list.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(list);
	 }
	 @GetMapping("get/{pid}")
	 public ResponseEntity<Product> getProductById(@PathVariable int pid){
		 
		Product product= productService.getProductById(pid);
		if(product==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(product);
	 }
	 @GetMapping("/{name}")
	 public ResponseEntity<List<Product>> getProductByName(@PathVariable String name){
		 
		List<Product> product= productService.getProductByName(name);
		if(product.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(product);
	 }
	 @GetMapping("less-then/{price}")
	 public ResponseEntity<List<Product>> getProductByLessThanPrice(@PathVariable int price){
		 
		List<Product> product= productService.getProductByLessThanPrice(price);
		if(product.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(product);
	 }
	 @GetMapping("greater-then/{price}")
	 public ResponseEntity<List<Product>> getProductByGreaterThanPrice(@PathVariable int price){
		 
		List<Product> product= productService.getProductByGreaterThanPrice(price);
		if(product.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(product);
	 }
	 @PutMapping("update/{pid}")
	 public ResponseEntity<Product> getUpdate(@PathVariable int pid , @RequestBody Product product){
		 Product products= productService.getProductById(pid);
		 if(products==null) {
			 return ResponseEntity.notFound().build();
		 }
		 product.setPid(pid);
		 productService.updateProduct(product);
		 return ResponseEntity.ok(product);
	 }
	 @PatchMapping("/update-Partilly/{pid}")
	 public ResponseEntity<Product> getUpdatePartilly(@PathVariable int pid , @RequestBody Product productNew){
		 Product productOld= productService.getProductById(pid);
		 if(productOld==null) {
			 return ResponseEntity.notFound().build();
		 }
		 productNew.setPid(pid);
		 productService.updateProductPartilly(productOld,productNew);
		 return ResponseEntity.ok(productOld);
	 } 
	 @DeleteMapping("/{pid}")
	 public ResponseEntity<Product> deleteProduct(@PathVariable int pid){
		 
		 Product product= productService.getProductById(pid);
		 
		 if(product==null) {
			 return ResponseEntity.notFound().build();
		 }
		 productService.deleteById(pid);
		return ResponseEntity.ok(product); 
	 }
}
