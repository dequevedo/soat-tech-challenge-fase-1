package com.hexagonalarch.core.ports.in;

import com.hexagonalarch.adapters.dto.response.GetProductResponse;
import com.hexagonalarch.core.domain.Product;

import java.util.List;

public interface GetAllProductsUseCase {

    List<Product> getAllProducts();

}
