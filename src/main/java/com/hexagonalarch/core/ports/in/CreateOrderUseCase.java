package com.hexagonalarch.core.ports.in;

import com.hexagonalarch.core.domain.Order;

import java.util.List;

public interface CreateOrderUseCase {

    Order createOrder(Long customerId, List<Long> snacks, List<Long> sides, List<Long> drinks, List<Long> desserts);

}
