package com.victor.hexagonalarch.infra.config;

import com.victor.hexagonalarch.infra.repository.SpringDataMongoOrderRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = SpringDataMongoOrderRepository.class)
public class MongoDBConfiguration {
}
