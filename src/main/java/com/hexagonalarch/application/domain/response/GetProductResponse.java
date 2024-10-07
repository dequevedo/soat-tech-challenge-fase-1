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
public class GetProductResponse {

    private Long id;

    private String name;

    private Float value;

    public static GetProductResponse valueOf(Product domain) {
        return GetProductResponse.builder()
                .id(domain.getId())
                .name(domain.getName())
                .build();
    }

}