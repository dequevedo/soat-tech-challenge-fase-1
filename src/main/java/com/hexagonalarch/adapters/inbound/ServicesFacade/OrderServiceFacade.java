package com.hexagonalarch.adapters.inbound.ServicesFacade;

import com.hexagonalarch.core.domain.Order;
import com.hexagonalarch.core.ports.in.CreateOrderUseCase;
import com.hexagonalarch.core.ports.in.GetAllOrdersUseCase;
import com.hexagonalarch.core.ports.in.GetOrderUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceFacade {

    private final CreateOrderUseCase createOrderUseCase;
    private final GetOrderUseCase getOrderUseCase;
    private final GetAllOrdersUseCase getAllOrdersUseCase;

    public OrderServiceFacade(CreateOrderUseCase createOrderUseCase, GetOrderUseCase getOrderUseCase, GetAllOrdersUseCase getAllOrdersUseCase) {
        this.createOrderUseCase = createOrderUseCase;
        this.getOrderUseCase = getOrderUseCase;
        this.getAllOrdersUseCase = getAllOrdersUseCase;
    }

    public Order createOrder(Order order) {
        return createOrderUseCase.createOrder(order);
    }

    public Order getOrderById(Long id) {
        return getOrderUseCase.getOrderById(id);
    }

    public List<Order> getAllOrders() {
        return getAllOrdersUseCase.getAllOrders();
    }
}
