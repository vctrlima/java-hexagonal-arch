package com.victor.hexagonalarch.domain.service.impl;

import com.victor.hexagonalarch.domain.entity.Order;
import com.victor.hexagonalarch.domain.entity.Product;
import com.victor.hexagonalarch.domain.repository.OrderRepository;
import com.victor.hexagonalarch.domain.service.OrderService;

import java.util.UUID;

public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order createOrder(Product product) {
        Order order = new Order(UUID.randomUUID().toString(), product);
        return orderRepository.save(order);
    }

    @Override
    public void addProduct(String id, final Product product) {
        final Order order = getOrder(id);
        order.addItem(product);
        orderRepository.save(order);
    }

    @Override
    public void completeOrder(String id) {
        Order order = getOrder(id);
        order.complete();
        orderRepository.save(order);
    }

    @Override
    public void deleteProduct(String id, final String productId) {
        Order order = getOrder(id);
        order.removeOrder(productId);
        orderRepository.save(order);
    }

    private Order getOrder(String id) {
        return orderRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Order with given ID doesn't exists"));
    }

}
