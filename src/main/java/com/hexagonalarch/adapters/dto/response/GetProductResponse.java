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
public class GetProductResponse {

    private Long id;

    private String name;

    private Float value;

}