package com.hexagonalarch.domain;

import com.hexagonalarch.domain.enumeration.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Order {

    private Long id;
    private Customer customer;
    private List<Product> products;
    private OrderStatus status;
    private Double totalPrice;

    public Double getTotalPrice() {
        return products.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }
}