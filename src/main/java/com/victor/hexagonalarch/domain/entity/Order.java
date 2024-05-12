package com.victor.hexagonalarch.domain.entity;

import com.victor.hexagonalarch.domain.enumerator.OrderStatus;
import com.victor.hexagonalarch.domain.exception.DomainException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "orders")
public class Order {

    @Id
    private String id;
    private List<OrderItem> items;
    private BigDecimal price;
    private OrderStatus status;

    public Order(String id, Product product) {
        this.id = id;
        this.items = new ArrayList<>(List.of(new OrderItem(product)));
        this.price = product.getPrice();
        this.status = OrderStatus.CREATED;
    }

    private void validateStatus() throws DomainException {
        if (status == OrderStatus.COMPLETED) {
            throw new DomainException("The order is in completed state");
        }
    }

    private void validateProduct(Product product) throws DomainException {
        if (product == null) {
            throw new DomainException("Product cannot be null");
        }
        if (!product.getActive()) {
            throw new DomainException("Product should be active");
        }
    }

    public void complete() {
        status = OrderStatus.COMPLETED;
    }

    public void addItem(Product product) {
        validateStatus();
        validateProduct(product);
        items.add(new OrderItem(product));
        price = price.add(product.getPrice());
    }

    public void removeOrder(String orderItemId) {
        validateStatus();
        final OrderItem item = getOrderItem(orderItemId);
        items.remove(item);
        price = price.subtract(item.getPrice());
    }

    public OrderItem getOrderItem(String orderItemId) {
        return items.stream()
                .filter(item -> item.getProductId().equals(orderItemId))
                .findFirst()
                .orElseThrow(() -> new DomainException("Product with given ID doesn't exists"));
    }

}
