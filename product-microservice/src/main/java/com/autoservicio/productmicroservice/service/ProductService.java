package com.autoservicio.productmicroservice.service;

import java.util.List;

import com.autoservicio.productmicroservice.dto.Product;

public interface ProductService {
	Product getProductById(String id);
	List<Product>getProductCoincidences(String coincidences);
}
