package com.hexagonalarch.adapters.outbound;

import com.hexagonalarch.domain.Product;
import com.hexagonalarch.application.ports.outbound.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class JpaProductRepository implements ProductRepository {

    private final JpaRepositoryAdapter jpaRepositoryAdapter;

    @Override
    public Product save(Product product) {
        return jpaRepositoryAdapter.save(product);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return jpaRepositoryAdapter.findById(id.toString());
    }

    @Override
    public List<Product> findAll() {
        return jpaRepositoryAdapter.findAll();
    }
}

