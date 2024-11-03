package com.hexagonalarch.adapters.inbound.ServicesFacade;

import com.hexagonalarch.adapters.dto.request.CreateOrderRequest;
import com.hexagonalarch.core.domain.Customer;
import com.hexagonalarch.core.domain.Order;
import com.hexagonalarch.core.domain.Product;
import com.hexagonalarch.core.domain.enumeration.OrderStatus;
import com.hexagonalarch.core.ports.in.CreateOrderUseCase;
import com.hexagonalarch.core.ports.in.GetAllOrdersUseCase;
import com.hexagonalarch.core.ports.in.GetOrderUseCase;
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
    private final CustomerRepositoryPort customerRepository;
    private final ProductRepositoryPort productRepository;

    public OrderServiceFacade(CreateOrderUseCase createOrderUseCase,
                              GetOrderUseCase getOrderUseCase,
                              GetAllOrdersUseCase getAllOrdersUseCase,
                              CustomerRepositoryPort customerRepository,
                              ProductRepositoryPort productRepository) {
        this.createOrderUseCase = createOrderUseCase;
        this.getOrderUseCase = getOrderUseCase;
        this.getAllOrdersUseCase = getAllOrdersUseCase;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }


    public Order createOrder(CreateOrderRequest createOrderRequest) {
        Customer customer = customerRepository.findById(createOrderRequest.getCustomerId())
                .orElseThrow(() -> new NotFoundException("Customer not found"));

        List<Product> snacks = getProductsByIds(createOrderRequest.getProductIds().getSnack());
        List<Product> sides = getProductsByIds(createOrderRequest.getProductIds().getSide());
        List<Product> drinks = getProductsByIds(createOrderRequest.getProductIds().getDrink());
        List<Product> desserts = getProductsByIds(createOrderRequest.getProductIds().getDessert());

        Order order = new Order(null, customer.getId(), OrderStatus.RECEBIDO, snacks, sides, drinks, desserts);

        return createOrderUseCase.createOrder(order);
    }

    public Order getOrderById(Long id) {
        return getOrderUseCase.getOrderById(id);
    }

    public List<Order> getAllOrders(OrderStatus statusFilter) {
        return getAllOrdersUseCase.getAllOrders(statusFilter);
    }

    private List<Product> getProductsByIds(List<Long> productIds) {
        return productIds.stream()
                .map(id -> productRepository.findById(id)
                        .orElseThrow(() -> new NotFoundException("Product not found for ID: " + id)))
                .toList();
    }
}
