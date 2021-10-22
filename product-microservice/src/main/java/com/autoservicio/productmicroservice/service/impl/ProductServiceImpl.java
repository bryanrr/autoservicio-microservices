package com.autoservicio.productmicroservice.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
	
	@Override
	public List<Product>getProductCoincidences(String coincidences){
		String[]words=coincidences.split(" ");
		String regexp="[\\w]*";
		
		for(String word:words) {
			regexp+=word+"[\\w\\s]*";
		}
		
		Sort sort=Sort.by(Sort.Direction.ASC, "description");
		
		return productRepository.findCoincidences(regexp,sort);
	}
}
