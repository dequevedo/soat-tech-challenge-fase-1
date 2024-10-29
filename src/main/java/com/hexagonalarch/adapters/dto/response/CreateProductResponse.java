package com.hexagonalarch.adapters.dto.response;

import com.hexagonalarch.core.domain.Product;
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

}