package com.hexagonalarch.application.ports.inbound;

import com.hexagonalarch.application.dto.request.CreateProductRequest;
import com.hexagonalarch.application.dto.response.CreateProductResponse;

public interface CreateProductUseCase {

    CreateProductResponse createProduct(CreateProductRequest createProductRequest);

}
