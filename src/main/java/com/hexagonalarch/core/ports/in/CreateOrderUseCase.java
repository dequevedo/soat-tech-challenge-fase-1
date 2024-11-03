package com.hexagonalarch.core.ports.in;

import com.hexagonalarch.core.domain.Order;

public interface CreateOrderUseCase {

    Order createOrder(Order order);

}
