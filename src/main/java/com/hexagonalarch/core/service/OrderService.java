package com.hexagonalarch.core.service;

import com.hexagonalarch.core.domain.Order;
import com.hexagonalarch.core.ports.in.CreateOrderUseCase;
import com.hexagonalarch.core.ports.in.GetAllOrdersUseCase;
import com.hexagonalarch.core.ports.in.GetOrderUseCase;
import com.hexagonalarch.core.ports.out.OrderRepositoryPort;

import java.util.List;
import java.util.Optional;

public class OrderService implements CreateOrderUseCase, GetOrderUseCase, GetAllOrdersUseCase {

    private final OrderRepositoryPort orderRepository;

    public OrderService(OrderRepositoryPort orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order getOrderById(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        return order.orElseThrow(() -> new RuntimeException("Order not found"));
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
