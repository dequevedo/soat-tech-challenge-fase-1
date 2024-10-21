package com.hexagonalarch.adapters.inbound;

import com.hexagonalarch.application.dto.request.CreateProductRequest;
import com.hexagonalarch.application.dto.response.CreateProductResponse;
import com.hexagonalarch.application.dto.response.GetProductResponse;
import com.hexagonalarch.application.ports.inbound.CreateProductUseCase;
import com.hexagonalarch.application.ports.inbound.GetAllProductsUseCase;
import com.hexagonalarch.application.ports.inbound.GetProductUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class ProductController {

    private final CreateProductUseCase createProductUseCase;

    private final GetProductUseCase getProductUseCase;

    private final GetAllProductsUseCase getAllProductsUseCase;

    @PostMapping(value = "/products")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateProductResponse createProduct(@Valid @RequestBody CreateProductRequest product) {
        return createProductUseCase.createProduct(product);
    }

    @GetMapping(value = "/products/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetProductResponse getProductById(@PathVariable Long id) {
        return getProductUseCase.getProductById(id);
    }

    @GetMapping(value = "/products")
    @ResponseStatus(HttpStatus.OK)
    public List<GetProductResponse> getAllProducts() {
        return getAllProductsUseCase.getAllProducts();
    }

}