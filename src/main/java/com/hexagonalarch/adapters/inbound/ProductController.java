//package com.hexagonalarch.adapters.inbound;
//
//import com.hexagonalarch.adapters.dto.request.CreateProductRequest;
//import com.hexagonalarch.adapters.dto.response.CreateProductResponse;
//import com.hexagonalarch.adapters.dto.response.GetProductResponse;
//import com.hexagonalarch.core.ports.in.CreateProductUseCase;
//import com.hexagonalarch.core.ports.in.GetAllProductsUseCase;
//import com.hexagonalarch.core.ports.in.GetProductUseCase;
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/v1")
//@RequiredArgsConstructor
//public class ProductController {
//
//    private final CreateProductUseCase createProductUseCase;
//
//    private final GetProductUseCase getProductUseCase;
//
//    private final GetAllProductsUseCase getAllProductsUseCase;
//
//    @PostMapping(value = "/products")
//    @ResponseStatus(HttpStatus.CREATED)
//    public CreateProductResponse createProduct(@Valid @RequestBody CreateProductRequest product) {
//        return createProductUseCase.createProduct(product);
//    }
//
//    @GetMapping(value = "/products/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public GetProductResponse getProductById(@PathVariable Long id) {
//        return getProductUseCase.getProductById(id);
//    }
//
//    @GetMapping(value = "/products")
//    @ResponseStatus(HttpStatus.OK)
//    public List<GetProductResponse> getAllProducts() {
//        return getAllProductsUseCase.getAllProducts();
//    }
//
//}