package com.hexagonalarch.application.service;

import com.hexagonalarch.application.dto.request.CreateProductRequest;
import com.hexagonalarch.application.dto.response.CreateProductResponse;
import com.hexagonalarch.application.dto.response.GetProductResponse;
import com.hexagonalarch.application.ports.inbound.CreateProductUseCase;
import com.hexagonalarch.application.ports.inbound.GetAllProductsUseCase;
import com.hexagonalarch.application.ports.inbound.GetProductUseCase;
import com.hexagonalarch.application.ports.outbound.ProductOutboundPort;
import com.hexagonalarch.domain.Product;
import com.hexagonalarch.domain.enumeration.ProductCategory;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class ProductService implements CreateProductUseCase, GetProductUseCase, GetAllProductsUseCase {

    private final ProductOutboundPort productRepository;

    @Override
    public CreateProductResponse createProduct(CreateProductRequest createProductRequest) {
        Product product = new Product(0L, "Teste", "A sample test", 10.0, ProductCategory.LANCHE);
        product.setName(createProductRequest.getName());
        product.setPrice(createProductRequest.getPrice());

        Product storedProduct = productRepository.save(product);

        return CreateProductResponse.valueOf(storedProduct);
    }

    @Override
    public GetProductResponse getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        Product storedProduct = product.orElseThrow(() -> new RuntimeException("Product not found"));

        return GetProductResponse.valueOf(storedProduct);
    }

    @Override
    public List<GetProductResponse> getAllProducts() {
        return productRepository.findAll().stream().map(GetProductResponse::valueOf).toList();
    }
}
