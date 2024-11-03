package com.hexagonalarch.core.domain;

import com.hexagonalarch.core.domain.enumeration.OrderStatus;

import java.util.List;

public class Order {

    private Long id;

    private Long customerId;

    private List<Product> snacks;

    private List<Product> sides;

    private List<Product> drinks;

    private List<Product> desserts;

    private OrderStatus status;

    public Order() {
    }

    public Order(Long id, Long customerId, List<Product> snacks, List<Product> sides, List<Product> drinks, List<Product> desserts, OrderStatus status) {
        this.id = id;
        this.customerId = customerId;
        this.snacks = snacks;
        this.sides = sides;
        this.drinks = drinks;
        this.desserts = desserts;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public List<Product> getSnacks() {
        return snacks;
    }

    public void setSnacks(List<Product> snacks) {
        this.snacks = snacks;
    }

    public List<Product> getSides() {
        return sides;
    }

    public void setSides(List<Product> sides) {
        this.sides = sides;
    }

    public List<Product> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<Product> drinks) {
        this.drinks = drinks;
    }

    public List<Product> getDesserts() {
        return desserts;
    }

    public void setDesserts(List<Product> desserts) {
        this.desserts = desserts;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Double getTotalPrice() {
        double total = 0.0;
        if (snacks != null) total += snacks.stream().mapToDouble(Product::getPrice).sum();
        if (sides != null) total += sides.stream().mapToDouble(Product::getPrice).sum();
        if (drinks != null) total += drinks.stream().mapToDouble(Product::getPrice).sum();
        if (desserts != null) total += desserts.stream().mapToDouble(Product::getPrice).sum();
        return total;
    }
}
