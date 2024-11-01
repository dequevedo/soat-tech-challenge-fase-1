package com.hexagonalarch.core.domain;

import com.hexagonalarch.core.domain.enumeration.OrderStatus;

import java.util.List;

public class Order {

    private Long id;
    private Customer customer;
    private List<Product> products;
    private OrderStatus status;
    private Double totalPrice;

    public Order() {
    }

    public Order(Long id, Customer customer, List<Product> products, OrderStatus status, Double totalPrice) {
        this.id = id;
        this.customer = customer;
        this.products = products;
        this.status = status;
        this.totalPrice = totalPrice;
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Double getTotalPrice() {
        return products == null ? 0.0 : products.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}