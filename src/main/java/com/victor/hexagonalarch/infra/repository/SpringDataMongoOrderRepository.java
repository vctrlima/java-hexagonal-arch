package com.victor.hexagonalarch.infra.repository;

import com.victor.hexagonalarch.domain.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataMongoOrderRepository extends MongoRepository<Order, String> {
}
