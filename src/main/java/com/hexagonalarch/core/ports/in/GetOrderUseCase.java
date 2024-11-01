package com.hexagonalarch.core.ports.in;

import com.hexagonalarch.core.domain.Order;

public interface GetOrderUseCase {

    Order getOrderById(Long id);

}
