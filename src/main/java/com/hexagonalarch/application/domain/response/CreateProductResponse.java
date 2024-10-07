package com.hexagonalarch.application.domain.response;

import com.hexagonalarch.application.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductResponse {

    private Long id;

    private String name;

    private Double price;

    public static CreateProductResponse valueOf(Product product) {
        return CreateProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .build();
    }

}