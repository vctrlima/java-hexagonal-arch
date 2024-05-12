package com.victor.hexagonalarch.application.controller;

import com.victor.hexagonalarch.application.dto.request.AddProductRequestDTO;
import com.victor.hexagonalarch.application.dto.request.CreateOrderRequestDTO;
import com.victor.hexagonalarch.application.dto.response.CreateOrderResponseDTO;
import com.victor.hexagonalarch.domain.entity.Order;
import com.victor.hexagonalarch.domain.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    CreateOrderResponseDTO createOrder(@RequestBody CreateOrderRequestDTO request) {
        Order order = orderService.createOrder(request.product());
        return new CreateOrderResponseDTO(order);
    }

    @PostMapping("/{id}/products")
    void addProduct(@PathVariable String id, @RequestBody AddProductRequestDTO request) throws Exception {
        orderService.addProduct(id, request.product());
    }

    @DeleteMapping("/{id}/products")
    void deleteProduct(@PathVariable String id, @RequestParam String productId) throws Exception {
        orderService.deleteProduct(id, productId);
    }

    @PostMapping("/{id}/complete")
    void completeOrder(@PathVariable String id) {
        orderService.completeOrder(id);
    }

}
