package com.victor.hexagonalarch.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private String id;
    private String name;
    private Boolean active;
    private BigDecimal price;

}
