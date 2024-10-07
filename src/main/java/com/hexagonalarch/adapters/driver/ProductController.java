package com.hexagonalarch.adapters.driver;

import com.hexagonalarch.application.domain.request.CreateProductRequest;
import com.hexagonalarch.application.domain.response.CreateProductResponse;
import com.hexagonalarch.application.domain.response.GetProductResponse;
import com.hexagonalarch.application.ports.input.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/products")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateProductResponse createProduct(@Valid @RequestBody CreateProductRequest product) {
        return productService.createProduct(product);
    }

    @GetMapping("/products/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetProductResponse getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @GetMapping("/products")
    @ResponseStatus(HttpStatus.OK)
    public List<GetProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }

}