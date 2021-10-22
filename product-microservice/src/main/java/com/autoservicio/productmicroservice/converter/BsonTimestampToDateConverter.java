package com.autoservicio.productmicroservice.converter;

import java.util.Date;

import org.bson.BsonTimestamp;
import org.springframework.core.convert.converter.Converter;

public class BsonTimestampToDateConverter implements Converter<BsonTimestamp, Date> {

	@Override
	public Date convert(BsonTimestamp source) {
		return new Date(source.getTime()*1000l);
	}

}
