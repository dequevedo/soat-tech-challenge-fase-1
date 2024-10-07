package com.hexagonalarch.application.ports.output;

import com.hexagonalarch.application.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    Product save(Product product);

    Optional<Product> findById(Long id);

    List<Product> findAll();

}