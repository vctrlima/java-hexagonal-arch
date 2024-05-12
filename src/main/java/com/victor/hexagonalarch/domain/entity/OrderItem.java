package com.victor.hexagonalarch.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {

    private String productId;
    private BigDecimal price;

    public OrderItem(Product product) {
        this.productId = product.getId();
        this.price = product.getPrice();
    }

}
