package com.hexagonalarch.application.ports.inbound;

import com.hexagonalarch.domain.request.CreateProductRequest;
import com.hexagonalarch.domain.response.CreateProductResponse;
import com.hexagonalarch.domain.response.GetProductResponse;

import java.util.List;

public interface ProductService {

    CreateProductResponse createProduct(CreateProductRequest product);

    GetProductResponse getProductById(Long id);

    List<GetProductResponse> getAllProducts();

}
