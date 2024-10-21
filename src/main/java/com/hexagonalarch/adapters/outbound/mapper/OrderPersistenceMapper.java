package com.hexagonalarch.adapters.outbound.mapper;

import com.hexagonalarch.adapters.outbound.entity.OrderEntity;
import com.hexagonalarch.domain.Order;
import org.mapstruct.Mapper;

@Mapper
public interface OrderPersistenceMapper {

    OrderEntity toOrderEntity(Order order);

    Order toOrder(OrderEntity orderEntity);

}
