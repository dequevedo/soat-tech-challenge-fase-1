package com.hexagonalarch.domain;

import com.hexagonalarch.application.dto.request.CreateProductRequest;
import com.hexagonalarch.domain.enumeration.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private ProductCategory category;

    public static Product valueOf(CreateProductRequest createProductRequest) {
        return Product.builder()
                .name(createProductRequest.getName())
                .description(createProductRequest.getDescription())
                .price(createProductRequest.getPrice())
                .category(ProductCategory.valueOf(createProductRequest.getCategory()))
                .build();
    }

}