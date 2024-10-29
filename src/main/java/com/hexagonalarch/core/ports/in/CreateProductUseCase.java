package com.hexagonalarch.core.ports.in;

import com.hexagonalarch.adapters.dto.request.CreateProductRequest;
import com.hexagonalarch.adapters.dto.response.CreateProductResponse;
import com.hexagonalarch.core.domain.Product;

public interface CreateProductUseCase {

    Product createProduct(Product product);

}
