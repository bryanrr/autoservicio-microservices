package com.autoservicio.autoserviciogateway.dto;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.annotation.Id;

import com.autoservicio.autoserviciogateway.model.Distributor;

import lombok.Data;


@Data
public class Product {
	@Id
	private String id;
	private String description;
	private BigDecimal purchasePrice;
	
	private BigDecimal sellingPrice;
	
	private Double stock;
	
	private Boolean fractional;
	
	private Boolean promotion;
	private Date lastUpdatedTime;
	private Distributor distributor;
}
