package com.autoservicio.productmicroservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.autoservicio.productmicroservice.dto.Product;
import com.autoservicio.productmicroservice.service.ProductService;


@RestController
public class ProductRestController {
	@Autowired
	ProductService productService;
	
	@RequestMapping(value="/product/{id}", method=RequestMethod.GET)
	public Product getProductById(@PathVariable("id") String id) {
		return productService.getProductById(id);
	}
}
