package com.autoservicio.autoserviciogateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.autoservicio.autoserviciogateway.client.ProductClient;
import com.autoservicio.autoserviciogateway.dto.Product;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class ProductController {

	private ProductClient productClient;
	
	public ProductController(ProductClient productClient) {
		this.productClient = productClient;
	}
	
	private Product fallback(String id) {
		return new Product();
	}

	@GetMapping("/item/{id}")
	@HystrixCommand(fallbackMethod = "fallback")
	public Product getProductById(@PathVariable("id")String id) {
		return productClient.getProductById(id);
	}
	
}
