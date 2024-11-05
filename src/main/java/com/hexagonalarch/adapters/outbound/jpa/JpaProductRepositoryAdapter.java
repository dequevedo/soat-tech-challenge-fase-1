package com.hexagonalarch.adapters.outbound.jpa;

import com.hexagonalarch.adapters.converters.ProductConverter;
import com.hexagonalarch.adapters.outbound.jpa.entity.CategoryEntity;
import com.hexagonalarch.adapters.outbound.jpa.entity.ProductEntity;
import com.hexagonalarch.core.ports.out.ProductRepositoryPort;
import com.hexagonalarch.core.domain.Product;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class JpaProductRepositoryAdapter implements ProductRepositoryPort {

    private final JpaProductRepository jpaRepository;
    private final ModelMapper modelMapper;
    private final JpaCategoryRepository jpaCategoryRepository;
    private final ProductConverter productConverter;
    @Override
    public Product save(Product product) {
        CategoryEntity categoryEntity = jpaCategoryRepository.findByName(product.getCategory().getValue())
                .orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada"));

        ProductEntity productEntity = modelMapper.map(product, ProductEntity.class);

        productEntity.setCategory(categoryEntity);

        ProductEntity savedProductEntity = jpaRepository.save(productEntity);
        return modelMapper.map(savedProductEntity, Product.class);
    }

    @Override
    public Optional<Product> findById(Long id) {
        Optional<ProductEntity> optionalProductEntity = jpaRepository.findById(id);
        return optionalProductEntity.map(productEntity -> productConverter.entityToDomain(optionalProductEntity.get()));
    }

    @Override
    public List<Product> findAll() {
        return jpaRepository.findAll().stream()
                .map(productEntity -> modelMapper.map(productEntity, Product.class))
                .toList();
    }
}

