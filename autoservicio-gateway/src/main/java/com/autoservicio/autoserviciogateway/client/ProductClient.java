package com.autoservicio.autoserviciogateway.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.autoservicio.autoserviciogateway.dto.Product;

@FeignClient("product-service")
public interface ProductClient {
	@GetMapping("/product/{id}")
	Product getProductById(@PathVariable("id")String id);
}
