package com.hexagonalarch.application.ports.input;

import com.hexagonalarch.application.domain.request.CreateProductRequest;
import com.hexagonalarch.application.domain.response.CreateProductResponse;
import com.hexagonalarch.application.domain.response.GetProductResponse;

import java.util.List;

public interface ProductService {

    CreateProductResponse createProduct(CreateProductRequest product);

    GetProductResponse getProductById(Long id);

    List<GetProductResponse> getAllProducts();

}
