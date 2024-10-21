package com.hexagonalarch.application.ports.outbound;

import com.hexagonalarch.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductOutboundPort {

    Product save(Product product);

    Optional<Product> findById(Long id);

    List<Product> findAll();

}