package com.hexagonalarch.adapters.outbound.jpa;

import com.hexagonalarch.adapters.outbound.jpa.entity.OrderEntity;
import com.hexagonalarch.core.domain.Order;
import com.hexagonalarch.core.ports.out.OrderRepositoryPort;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class JpaOrderRepositoryAdapter implements OrderRepositoryPort {

    private final JpaOrderRepository jpaRepository;
    private final ModelMapper modelMapper;

    @Override
    public Order save(Order order) {
        OrderEntity orderEntity = jpaRepository.save(modelMapper.map(order, OrderEntity.class));
        return modelMapper.map(orderEntity, Order.class);
    }

    @Override
    public Optional<Order> findById(Long id) {
        Optional<OrderEntity> optionalOrderEntity = jpaRepository.findById(id);
        return optionalOrderEntity.map(orderEntity -> modelMapper.map(orderEntity, Order.class));
    }

    @Override
    public List<Order> findAll() {
        return jpaRepository.findAll().stream()
                .map(orderEntity -> modelMapper.map(orderEntity, Order.class))
                .toList();
    }
}

