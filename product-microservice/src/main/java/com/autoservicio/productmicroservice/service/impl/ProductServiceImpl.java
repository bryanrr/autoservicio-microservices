package com.autoservicio.productmicroservice.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autoservicio.productmicroservice.dto.Product;
import com.autoservicio.productmicroservice.repository.ProductRepository;
import com.autoservicio.productmicroservice.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public Product getProductById(String id) {
		Optional<Product>product=productRepository.findById(id.toUpperCase());
		
		return product.isPresent()?product.get():new Product();
	}
}
