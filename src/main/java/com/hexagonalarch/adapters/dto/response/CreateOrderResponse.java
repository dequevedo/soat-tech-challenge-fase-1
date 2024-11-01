package com.hexagonalarch.adapters.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderResponse {
    private Long orderId;
    private String status;
    private List<ProductDetail> products;

    //TODO isso é um value object?
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ProductDetail {
        private Long productId;
        private String name;
        private BigDecimal price;
    }
}