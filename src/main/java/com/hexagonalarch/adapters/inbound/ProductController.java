package com.hexagonalarch.adapters.inbound;

import com.hexagonalarch.application.dto.request.CreateProductRequest;
import com.hexagonalarch.application.dto.response.CreateProductResponse;
import com.hexagonalarch.application.dto.response.GetProductResponse;
import com.hexagonalarch.application.ports.inbound.CreateProductUseCase;
import com.hexagonalarch.application.ports.inbound.GetAllProductsUseCase;
import com.hexagonalarch.application.ports.inbound.GetProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final CreateProductUseCase createProductUseCase;

    private final GetProductUseCase getProductUseCase;

    private final GetAllProductsUseCase getAllProductsUseCase;

    @PostMapping("/products")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateProductResponse createProduct(@Valid @RequestBody CreateProductRequest product) {
        return createProductUseCase.createProduct(product);
    }

    @GetMapping("/products/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetProductResponse getProductById(@PathVariable Long id) {
        return getProductUseCase.getProductById(id);
    }

    @GetMapping("/products")
    @ResponseStatus(HttpStatus.OK)
    public List<GetProductResponse> getAllProducts() {
        return getAllProductsUseCase.getAllProducts();
    }

}