package com.victor.hexagonalarch.domain.service;

import com.victor.hexagonalarch.domain.entity.Order;
import com.victor.hexagonalarch.domain.entity.Product;

public interface OrderService {

    Order createOrder(Product product);

    void addProduct(String id, Product product) throws Exception;

    void completeOrder(String id);

    void deleteProduct(String id, String productId) throws Exception;

}
