package com.hexagonalarch.application.usecases;

import com.hexagonalarch.domain.Product;
import com.hexagonalarch.application.dto.request.CreateProductRequest;
import com.hexagonalarch.application.dto.response.CreateProductResponse;
import com.hexagonalarch.application.dto.response.GetProductResponse;
import com.hexagonalarch.application.ports.inbound.ProductService;
import com.hexagonalarch.application.ports.outbound.ProductRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public CreateProductResponse createProduct(CreateProductRequest createProductRequest) {
        Product product = new Product();
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
