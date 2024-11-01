package com.hexagonalarch.adapters.inbound;

import com.hexagonalarch.adapters.converters.GenericConverter;
import com.hexagonalarch.adapters.dto.request.CreateOrderRequest;
import com.hexagonalarch.adapters.dto.response.CreateOrderResponse;
import com.hexagonalarch.adapters.dto.response.GetOrderResponse;
import com.hexagonalarch.adapters.inbound.ServicesFacade.OrderServiceFacade;
import com.hexagonalarch.core.domain.Order;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderServiceFacade orderServiceFacade;
    private final GenericConverter genericConverter;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateOrderResponse createOrder(@Valid @RequestBody CreateOrderRequest orderRequest) {
        Order orderInput = genericConverter.toDomain(orderRequest, Order.class);
        Order newOrder = orderServiceFacade.createOrder(orderInput);
        return genericConverter.toDto(newOrder, CreateOrderResponse.class);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetOrderResponse getOrderById(@PathVariable Long id) {
        Order order = orderServiceFacade.getOrderById(id);
        return genericConverter.toDto(order, GetOrderResponse.class);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetOrderResponse> getAllOrders() {
        return orderServiceFacade.getAllOrders()
                .stream()
                .map(order -> genericConverter.toDto(order, GetOrderResponse.class))
                .toList();
    }
}
