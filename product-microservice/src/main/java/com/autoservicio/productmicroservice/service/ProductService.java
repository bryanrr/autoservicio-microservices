package com.autoservicio.productmicroservice.service;

import com.autoservicio.productmicroservice.dto.Product;

public interface ProductService {
	Product getProductById(String id);
}
