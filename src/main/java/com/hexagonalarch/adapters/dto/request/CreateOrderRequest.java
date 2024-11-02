package com.hexagonalarch.adapters.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderRequest {

    private Long customerId;

    @NotNull(message = "productIds must not be null")
    private ProductIds productIds;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ProductIds {

        @NotNull(message = "snack must not be null")
        private List<Long> snack;

        @NotNull(message = "side must not be null")
        private List<Long> side;

        @NotNull(message = "drink must not be null")
        private List<Long> drink;

        @NotNull(message = "dessert must not be null")
        private List<Long> dessert;
    }
}