package com.hexagonalarch.adapters.outbound.jpa;

import com.hexagonalarch.adapters.outbound.jpa.entity.CustomerEntity;
import com.hexagonalarch.adapters.outbound.jpa.entity.ProductEntity;
import com.hexagonalarch.core.domain.Customer;
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

    @Override
    public Product save(Product product) {
        ProductEntity productEntity = jpaRepository.save(modelMapper.map(product, ProductEntity.class));
        return modelMapper.map(productEntity, Product.class);
    }

    @Override
    public Optional<Product> findById(Long id) {
        Optional<ProductEntity> optionalProductEntity = jpaRepository.findById(id);
        return optionalProductEntity.map(productEntity -> modelMapper.map(productEntity, Product.class));
    }

    @Override
    public List<Product> findAll() {
        return jpaRepository.findAll().stream()
                .map(productEntity -> modelMapper.map(productEntity, Product.class))
                .toList();
    }
}

