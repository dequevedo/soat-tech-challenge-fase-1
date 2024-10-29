package com.hexagonalarch.core.domain;

import com.hexagonalarch.core.domain.enumeration.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
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