package com.victor.hexagonalarch.infra.config;

import com.victor.hexagonalarch.domain.repository.OrderRepository;
import com.victor.hexagonalarch.domain.service.OrderService;
import com.victor.hexagonalarch.domain.service.impl.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    OrderService orderService(OrderRepository orderRepository) {
        return new OrderServiceImpl(orderRepository);
    }

}
