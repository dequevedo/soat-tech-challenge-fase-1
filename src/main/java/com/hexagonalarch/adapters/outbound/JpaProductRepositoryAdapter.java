package com.hexagonalarch.adapters.outbound;

import com.hexagonalarch.adapters.outbound.entity.ProductEntity;
import com.hexagonalarch.adapters.outbound.mapper.ProductPersistenceMapper;
import com.hexagonalarch.application.ports.outbound.ProductRepository;
import com.hexagonalarch.domain.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class JpaProductRepositoryAdapter implements ProductRepository {

    private final JpaProductRepository jpaRepository;

    private final ProductPersistenceMapper productPersistenceMapper;

    @Override
    public Product save(Product product) {
        ProductEntity productEntity = jpaRepository.save(productPersistenceMapper.toProductEntity(product));
        return productPersistenceMapper.toProduct(productEntity);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return jpaRepository.findById(id)
                .map(productPersistenceMapper::toProduct);
    }

    @Override
    public List<Product> findAll() {
        return jpaRepository.findAll().stream()
                .map(productPersistenceMapper::toProduct)
                .toList();
    }

}

