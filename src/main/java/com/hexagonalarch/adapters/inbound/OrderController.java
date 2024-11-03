package com.hexagonalarch.adapters.inbound;

import com.hexagonalarch.adapters.converters.GenericConverter;
import com.hexagonalarch.adapters.dto.request.CreateOrderRequest;
import com.hexagonalarch.adapters.dto.response.CreateOrderResponse;
import com.hexagonalarch.adapters.dto.response.GetOrderResponse;
import com.hexagonalarch.adapters.inbound.ServicesFacade.OrderServiceFacade;
import com.hexagonalarch.core.domain.Order;
import com.hexagonalarch.core.domain.enumeration.OrderStatus;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
@Tag(name = "Orders", description = "Operations related to Orders")
public class OrderController {

    private final OrderServiceFacade orderServiceFacade;
    private final GenericConverter genericConverter;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateOrderResponse createOrder(@Valid @RequestBody CreateOrderRequest createOrderRequest) {
        Order newOrder = orderServiceFacade.createOrder(createOrderRequest);
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
    public List<GetOrderResponse> getAllOrders(@RequestParam(required = false) OrderStatus statusFilter) {
        List<Order> orders = orderServiceFacade.getAllOrders(statusFilter);
        return orders.stream()
                .map(order -> genericConverter.toDto(order, GetOrderResponse.class))
                .toList();
    }
}
