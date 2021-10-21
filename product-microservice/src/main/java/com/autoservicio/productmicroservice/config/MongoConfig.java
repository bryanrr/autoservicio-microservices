package com.autoservicio.productmicroservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration{
	@Value("${mongo.database}")
	private String database;
	@Value("${mongo.host}")
	private String host;
	@Value("${mongo.port}")
	private String port;

	@Override
	protected MongoClient createMongoClient(MongoClientSettings settings) {
		final ConnectionString connectionString = new ConnectionString("mongodb://"+host+":"+port+"/"+database);
		
		return MongoClients.create(MongoClientSettings.builder().applyConnectionString(connectionString).build());
	}

	@Override
	protected String getDatabaseName() {
		return database;
	}

}
