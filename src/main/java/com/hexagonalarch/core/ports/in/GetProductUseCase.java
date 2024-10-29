package com.hexagonalarch.core.ports.in;

import com.hexagonalarch.adapters.dto.response.GetProductResponse;
import com.hexagonalarch.core.domain.Product;

public interface GetProductUseCase {

    Product getProductById(Long id);

}
