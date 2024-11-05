package com.hexagonalarch.adapters.dto.response;

import com.hexagonalarch.core.domain.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetProductResponse {

    private Long id;

    private String name;

    private Double price;

    private String description;

    private ProductCategory category;

}