package com.victor.hexagonalarch.domain.repository;

import com.victor.hexagonalarch.domain.entity.Order;

import java.util.Optional;

public interface OrderRepository {

    Optional<Order> findById(String id);

    Order save(Order order);

}
