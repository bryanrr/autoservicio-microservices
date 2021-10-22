package com.autoservicio.productmicroservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@RequestMapping(value="/product/coincidences/{coincidences}", method=RequestMethod.GET)
	public List<Product> getProductsByCoincidences(@PathVariable("coincidences")String coincidences){
		return productService.getProductCoincidences(coincidences);
	}
	
	@RequestMapping(value="/product/update/price", method=RequestMethod.PUT)
	public Product updateProductPrices(@RequestBody Product product){
		return productService.updateProductPrices(product);
	}
}
