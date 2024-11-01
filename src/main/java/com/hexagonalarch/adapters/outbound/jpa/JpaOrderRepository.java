package com.hexagonalarch.adapters.outbound.jpa;

import com.hexagonalarch.adapters.outbound.jpa.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaOrderRepository extends JpaRepository<OrderEntity, Long> {
}
