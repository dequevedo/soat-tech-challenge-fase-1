package com.hexagonalarch.core.service;

import com.hexagonalarch.core.domain.Order;
import com.hexagonalarch.core.domain.enumeration.OrderStatus;
import com.hexagonalarch.core.ports.in.CreateOrderUseCase;
import com.hexagonalarch.core.ports.in.GetAllOrdersUseCase;
import com.hexagonalarch.core.ports.in.GetOrderUseCase;
import com.hexagonalarch.core.ports.out.CustomerRepositoryPort;
import com.hexagonalarch.core.ports.out.OrderRepositoryPort;
import com.hexagonalarch.core.ports.out.ProductRepositoryPort;
import com.hexagonalarch.core.service.validations.factory.OrderValidationFactory;
import com.hexagonalarch.exception.NotFoundException;

import java.util.List;
import java.util.Optional;

public class OrderService implements CreateOrderUseCase, GetOrderUseCase, GetAllOrdersUseCase {

    private final OrderRepositoryPort orderRepository;
    private final CustomerRepositoryPort customerRepository;
    private final ProductRepositoryPort productRepository;

    public OrderService(OrderRepositoryPort orderRepository, CustomerRepositoryPort customerRepository, ProductRepositoryPort productRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Order createOrder(Order order) {
        customerRepository.findById(order.getCustomerId())
                .orElseThrow(() -> new NotFoundException("Customer not found"));

        order.getSnacks().forEach(snack -> productRepository.findById(snack.getId())
                .orElseThrow(() -> new NotFoundException("Product not found for ID: " + snack.getId())));

        order.getSides().forEach(side -> productRepository.findById(side.getId())
                .orElseThrow(() -> new NotFoundException("Product not found for ID: " + side.getId())));

        order.getDrinks().forEach(drink -> productRepository.findById(drink.getId())
                .orElseThrow(() -> new NotFoundException("Product not found for ID: " + drink.getId())));

        order.getDesserts().forEach(dessert -> productRepository.findById(dessert.getId())
                .orElseThrow(() -> new NotFoundException("Product not found for ID: " + dessert.getId())));

        order.setStatus(OrderStatus.RECEBIDO);

        OrderValidationFactory.getValidatorsForCreateOrder().validate(order);

        return orderRepository.save(order);
    }

    @Override
    public Order getOrderById(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        return order.orElseThrow(() -> new NotFoundException("Order not found"));
    }

    @Override
    public List<Order> getAllOrders(OrderStatus statusFilter) {
        return orderRepository.findAll(statusFilter);
    }
}
