package com.autoservicio.productmicroservice.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.autoservicio.productmicroservice.dto.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
	@Query("{'description':{$regex:?0,$options:'i'}}")
	List<Product>findCoincidences(String regex,Sort sort);
}
