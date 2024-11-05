package com.hexagonalarch.adapters.dto.response;

import com.hexagonalarch.core.domain.enumeration.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderResponse {

    private Long id;

    private Long customerId;

    private OrderStatus status;

    private List<CreateOrderProductResponse> snacks;

    private List<CreateOrderProductResponse> sides;

    private List<CreateOrderProductResponse> drinks;

    private List<CreateOrderProductResponse> desserts;

}