package com.hexagonalarch.core.ports.out;

import com.hexagonalarch.core.domain.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepositoryPort {

    Order save(Order order);

    Optional<Order> findById(Long id);

    List<Order> findAll();

}