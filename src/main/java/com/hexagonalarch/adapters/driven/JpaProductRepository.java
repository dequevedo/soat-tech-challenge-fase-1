package com.hexagonalarch.adapters.driven;

import com.hexagonalarch.application.domain.Product;
import com.hexagonalarch.application.ports.output.ProductRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaProductRepository extends JpaRepository<Product, Long>, ProductRepository {

}