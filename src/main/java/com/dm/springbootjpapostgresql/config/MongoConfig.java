package com.dm.springbootjpapostgresql.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(
    basePackages = "com.dm.springbootjpapostgresql.repository.mongo"
)
public class MongoConfig {
}

