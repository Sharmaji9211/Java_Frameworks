package com.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Product API", version = "1.0", description = "Product Management API"))
public class ProductServiceSwaggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceSwaggerApplication.class, args);
	}

}
