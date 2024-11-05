package com.hexagonalarch.adapters.converters;
import com.hexagonalarch.adapters.dto.request.CreateProductRequest;
import com.hexagonalarch.adapters.dto.response.CreateProductResponse;
import com.hexagonalarch.adapters.outbound.jpa.entity.ProductEntity;
import com.hexagonalarch.core.domain.Product;
import com.hexagonalarch.core.domain.ProductCategory;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    public Product toDomain(CreateProductRequest request) {
        return new Product(null, request.getName(), request.getDescription(),
                request.getPrice(), new ProductCategory(request.getCategory()));
    }

    public CreateProductResponse toResponse(Product product) {
        return CreateProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .category(product.getCategory())
                .build();
    }

    public Product entityToDomain(ProductEntity productEntity) {
        if (productEntity == null) return null;
        ProductCategory category = new ProductCategory(productEntity.getCategory().getName());
        return new Product(productEntity.getId(), productEntity.getName(), productEntity.getDescription(),
                productEntity.getPrice(), category);
    }
}
