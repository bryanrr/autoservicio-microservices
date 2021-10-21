package com.autoservicio.productmicroservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.autoservicio.productmicroservice.dto.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

}
