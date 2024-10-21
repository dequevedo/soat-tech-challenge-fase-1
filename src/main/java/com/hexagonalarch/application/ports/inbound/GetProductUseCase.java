package com.hexagonalarch.application.ports.inbound;

import com.hexagonalarch.application.dto.response.GetProductResponse;

public interface GetProductUseCase {

    GetProductResponse getProductById(Long id);

}
