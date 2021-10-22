package com.autoservicio.productmicroservice.dto;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import com.autoservicio.productmicroservice.model.Distributor;

import lombok.Data;


@Data
@Document(collection="product")
public class Product {
	@Id
	private String id;
	private String description;
	@Field(targetType = FieldType.DOUBLE)
	private BigDecimal purchasePrice;
	@Field(targetType = FieldType.DOUBLE)
	private BigDecimal sellingPrice;
	@Field(targetType = FieldType.DOUBLE)
	private Double stock;
	@Field(targetType = FieldType.BOOLEAN)
	private Boolean fractional;
	@Field(targetType = FieldType.BOOLEAN)
	private Boolean promotion;
	private Date lastUpdatedTime;
	private Distributor distributor;
}
