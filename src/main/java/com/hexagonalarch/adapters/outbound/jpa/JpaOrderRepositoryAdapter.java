package com.hexagonalarch.adapters.outbound.jpa;

import com.hexagonalarch.adapters.converters.ProductConverter;
import com.hexagonalarch.adapters.outbound.jpa.entity.OrderEntity;
import com.hexagonalarch.adapters.outbound.jpa.entity.OrderStatusEntity;
import com.hexagonalarch.adapters.outbound.jpa.entity.ProductEntity;
import com.hexagonalarch.core.domain.Order;
import com.hexagonalarch.core.domain.enumeration.OrderStatus;
import com.hexagonalarch.core.ports.out.OrderRepositoryPort;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class JpaOrderRepositoryAdapter implements OrderRepositoryPort {

    private final JpaOrderRepository jpaRepository;
    private final JpaOrderStatusRepository jpaOrderStatusRepository;
    private final JpaCategoryRepository jpaCategoryRepository;
    private final ProductConverter productConverter;
    private final ModelMapper modelMapper;

    @Override
    public Order save(Order order) {
        OrderEntity orderEntity = modelMapper.map(order, OrderEntity.class);

        OrderStatusEntity status = jpaOrderStatusRepository.findByStatus(order.getStatus())
                .orElseThrow(() -> new IllegalArgumentException("Esse status não existe"));
        orderEntity.setStatus(status);

        List<ProductEntity> productEntities = order.getProducts().stream()
                .map(productConverter::domainToEntity)
                .collect(Collectors.toList());
        orderEntity.setProducts(productEntities);

        OrderEntity savedOrderEntity = jpaRepository.save(orderEntity);

        Order savedOrder = modelMapper.map(savedOrderEntity, Order.class);

        savedOrder.setProducts(savedOrderEntity.getProducts().stream()
                .map(productConverter::entityToDomain)
                .collect(Collectors.toList()));

        return savedOrder;
    }

    @Override
    public Optional<Order> findById(Long id) {
        Optional<OrderEntity> optionalOrderEntity = jpaRepository.findById(id);
        return optionalOrderEntity.map(orderEntity -> modelMapper.map(orderEntity, Order.class));
    }

    @Override
    public List<Order> findAll(OrderStatus orderStatus) {
        List<OrderEntity> orderEntities;
        if (orderStatus == null) {
            orderEntities = jpaRepository.findAll();
        } else {
            OrderStatusEntity statusEntity = jpaOrderStatusRepository.findByStatus(orderStatus)
                    .orElseThrow(() -> new IllegalArgumentException("Status não encontrado"));

            orderEntities = jpaRepository.findAllByStatus(statusEntity);
        }

        return orderEntities.stream()
                .map(orderEntity -> {
                    Order order = modelMapper.map(orderEntity, Order.class);
                    order.setProducts(orderEntity.getProducts().stream()
                            .map(productConverter::entityToDomain)
                            .collect(Collectors.toList()));
                    return order;
                })
                .collect(Collectors.toList());

    }
}

