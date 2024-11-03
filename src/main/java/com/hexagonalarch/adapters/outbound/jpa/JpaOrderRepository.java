package com.hexagonalarch.adapters.outbound.jpa;

import com.hexagonalarch.adapters.outbound.jpa.entity.OrderEntity;
import com.hexagonalarch.core.domain.enumeration.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaOrderRepository extends JpaRepository<OrderEntity, Long> {

    List<OrderEntity> findAllByStatus(OrderStatus orderStatus);

}
