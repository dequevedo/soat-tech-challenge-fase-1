package com.hexagonalarch.core.domain;

import com.hexagonalarch.core.domain.enumeration.OrderStatus;

import java.util.List;

public class Order {

    private Long id;

    private Customer customer;

    private List<Product> snack;

    private List<Product> side;

    private List<Product> drink;

    private List<Product> dessert;

    private OrderStatus status;

    public Order() {
    }

    public Order(Long id, Customer customer, List<Product> snack, List<Product> side, List<Product> drink, List<Product> dessert, OrderStatus status) {
        this.id = id;
        this.customer = customer;
        this.snack = snack;
        this.side = side;
        this.drink = drink;
        this.dessert = dessert;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getSnack() {
        return snack;
    }

    public void setSnack(List<Product> snack) {
        this.snack = snack;
    }

    public List<Product> getSide() {
        return side;
    }

    public void setSide(List<Product> side) {
        this.side = side;
    }

    public List<Product> getDrink() {
        return drink;
    }

    public void setDrink(List<Product> drink) {
        this.drink = drink;
    }

    public List<Product> getDessert() {
        return dessert;
    }

    public void setDessert(List<Product> dessert) {
        this.dessert = dessert;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Double getTotalPrice() {
        double total = 0.0;
        if (snack != null) total += snack.stream().mapToDouble(Product::getPrice).sum();
        if (side != null) total += side.stream().mapToDouble(Product::getPrice).sum();
        if (drink != null) total += drink.stream().mapToDouble(Product::getPrice).sum();
        if (dessert != null) total += dessert.stream().mapToDouble(Product::getPrice).sum();
        return total;
    }
}
