package com.hexagonalarch.adapters.outbound;

import com.hexagonalarch.application.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface JpaRepositoryAdapter extends JpaRepository<Product, String> {
}
