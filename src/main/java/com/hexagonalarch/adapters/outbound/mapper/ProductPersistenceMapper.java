package com.hexagonalarch.adapters.outbound.mapper;

import com.hexagonalarch.adapters.outbound.entity.ProductEntity;
import com.hexagonalarch.domain.Product;
import org.mapstruct.Mapper;

@Mapper
public interface ProductPersistenceMapper {

    ProductEntity toProductEntity(Product product);

    Product toProduct(ProductEntity productEntity);

}
