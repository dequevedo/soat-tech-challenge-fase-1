package com.hexagonalarch.core.ports.in;

import com.hexagonalarch.core.domain.Order;

import java.util.List;

public interface GetAllOrdersUseCase {

    List<Order> getAllOrders();

}
