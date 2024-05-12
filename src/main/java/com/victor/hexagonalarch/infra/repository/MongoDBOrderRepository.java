package com.victor.hexagonalarch.infra.repository;

import com.victor.hexagonalarch.domain.entity.Order;
import com.victor.hexagonalarch.domain.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MongoDBOrderRepository implements OrderRepository {

    private final SpringDataMongoOrderRepository orderRepository;

    @Autowired
    public MongoDBOrderRepository(final SpringDataMongoOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Optional<Order> findById(String id) {
        return orderRepository.findById(id);
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

}