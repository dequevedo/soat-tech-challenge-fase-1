package com.hexagonalarch.adapters.inbound.ServicesFacade;

import com.hexagonalarch.adapters.dto.request.CreateOrderRequest;
import com.hexagonalarch.core.domain.Customer;
import com.hexagonalarch.core.domain.Order;
import com.hexagonalarch.core.domain.Product;
import com.hexagonalarch.core.domain.enumeration.OrderStatus;
import com.hexagonalarch.core.ports.in.Order.CreateOrderUseCase;
import com.hexagonalarch.core.ports.in.Order.GetAllOrdersUseCase;
import com.hexagonalarch.core.ports.in.Order.GetOrderUseCase;
import com.hexagonalarch.core.ports.in.Order.UpdateOrderStatusUseCase;
import com.hexagonalarch.core.ports.out.CustomerRepositoryPort;
import com.hexagonalarch.core.ports.out.ProductRepositoryPort;
import com.hexagonalarch.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceFacade {

    private final CreateOrderUseCase createOrderUseCase;
    private final GetOrderUseCase getOrderUseCase;
    private final GetAllOrdersUseCase getAllOrdersUseCase;
    private final UpdateOrderStatusUseCase updateOrderStatusUseCase;

    private final CustomerRepositoryPort customerRepository;
    private final ProductRepositoryPort productRepository;

    public OrderServiceFacade(CreateOrderUseCase createOrderUseCase,
                              GetOrderUseCase getOrderUseCase,
                              GetAllOrdersUseCase getAllOrdersUseCase,
                              UpdateOrderStatusUseCase updateOrderStatusUseCase,
                              CustomerRepositoryPort customerRepository,
                              ProductRepositoryPort productRepository) {
        this.createOrderUseCase = createOrderUseCase;
        this.getOrderUseCase = getOrderUseCase;
        this.getAllOrdersUseCase = getAllOrdersUseCase;
        this.updateOrderStatusUseCase = updateOrderStatusUseCase;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }


    public Order createOrder(CreateOrderRequest createOrderRequest) {
        Customer customer = customerRepository.findById(createOrderRequest.getCustomerId())
                .orElseThrow(() -> new NotFoundException("Customer not found"));

        List<Product> products = createOrderRequest.getProductIds().stream()
                .map(id -> productRepository.findById(id)
                        .orElseThrow(() -> new NotFoundException("Product not found for ID: " + id)))
                .toList();

        Order order = new Order(null, customer.getId(), OrderStatus.RECEBIDO, products);

        return createOrderUseCase.createOrder(order);
    }

    public Order getOrderById(Long id) {
        return getOrderUseCase.getOrderById(id);
    }

    public List<Order> getAllOrders(OrderStatus statusFilter) {
        return getAllOrdersUseCase.getAllOrders(statusFilter);
    }

    public void updateOrderStatus(Long id, OrderStatus status) {
        updateOrderStatusUseCase.updateOrderStatus(id, status);
    }

}
