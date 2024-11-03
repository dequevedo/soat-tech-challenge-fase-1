package com.hexagonalarch.core.ports.in;

import com.hexagonalarch.core.domain.Order;
import com.hexagonalarch.core.domain.enumeration.OrderStatus;

import java.util.List;

public interface GetAllOrdersUseCase {

    List<Order> getAllOrders(OrderStatus statusFilter);

}
