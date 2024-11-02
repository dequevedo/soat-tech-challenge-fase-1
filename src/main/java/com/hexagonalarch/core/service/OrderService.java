package com.hexagonalarch.core.service;

import com.hexagonalarch.core.domain.Customer;
import com.hexagonalarch.core.domain.Order;
import com.hexagonalarch.core.domain.Product;
import com.hexagonalarch.core.domain.enumeration.OrderStatus;
import com.hexagonalarch.core.ports.in.CreateOrderUseCase;
import com.hexagonalarch.core.ports.in.GetAllOrdersUseCase;
import com.hexagonalarch.core.ports.in.GetOrderUseCase;
import com.hexagonalarch.core.ports.out.CustomerRepositoryPort;
import com.hexagonalarch.core.ports.out.OrderRepositoryPort;
import com.hexagonalarch.core.ports.out.ProductRepositoryPort;
import com.hexagonalarch.core.service.validations.ValidationResult;
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
    public Order createOrder(Long customerId, List<Long> snacks, List<Long> sides, List<Long> drinks, List<Long> desserts) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new NotFoundException("Customer not found"));

        List<Product> snackProducts = snacks.stream()
                .map(id -> productRepository.findById(id)
                        .orElseThrow(() -> new NotFoundException("Product not found for ID: " + id)))
                .toList();

        List<Product> sideProducts = sides.stream()
                .map(id -> productRepository.findById(id)
                        .orElseThrow(() -> new NotFoundException("Product not found for ID: " + id)))
                .toList();

        List<Product> drinkProducts = drinks.stream()
                .map(id -> productRepository.findById(id)
                        .orElseThrow(() -> new NotFoundException("Product not found for ID: " + id)))
                .toList();

        List<Product> dessertProducts = desserts.stream()
                .map(id -> productRepository.findById(id)
                        .orElseThrow(() -> new NotFoundException("Product not found for ID: " + id)))
                .toList();

        Order order = new Order();
        order.setCustomer(customer);
        order.setSnack(snackProducts);
        order.setSide(sideProducts);
        order.setDrink(drinkProducts);
        order.setDessert(dessertProducts);
        order.setStatus(OrderStatus.RECEBIDO);

        ValidationResult validate = OrderValidationFactory.getValidatorsForCreateOrder().validate(order);

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
