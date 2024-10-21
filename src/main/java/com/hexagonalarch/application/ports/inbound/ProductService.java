package com.hexagonalarch.application.ports.inbound;

import com.hexagonalarch.application.dto.request.CreateProductRequest;
import com.hexagonalarch.application.dto.response.CreateProductResponse;
import com.hexagonalarch.application.dto.response.GetProductResponse;

import java.util.List;

public interface ProductService {

    CreateProductResponse createProduct(CreateProductRequest product);

    GetProductResponse getProductById(Long id);

    List<GetProductResponse> getAllProducts();

}
