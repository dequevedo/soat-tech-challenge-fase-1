//package com.hexagonalarch.adapters.outbound.jpa;
//
//import com.hexagonalarch.adapters.outbound.jpa.entity.ProductEntity;
//import com.hexagonalarch.core.ports.out.ProductRepositoryPort;
//import com.hexagonalarch.core.domain.Product;
//import lombok.AllArgsConstructor;
//
//import java.util.List;
//import java.util.Optional;
//
//@AllArgsConstructor
//public class JpaProductRepositoryAdapter implements ProductRepositoryPort {
//
//    private final JpaProductRepository jpaRepository;
//
//    @Override
//    public Product save(Product product) {
//        ProductEntity productEntity = jpaRepository.save(toProductEntity(product));
//        return toProduct(productEntity);
//    }
//
//    @Override
//    public Optional<Product> findById(Long id) {
//        Optional<ProductEntity> optionalProductEntity = jpaRepository.findById(id);
//        return optionalProductEntity.map(this::toProduct);
//    }
//
//    @Override
//    public List<Product> findAll() {
//        return jpaRepository.findAll().stream()
//                .map(this::toProduct)
//                .toList();
//    }
//
//    private ProductEntity toProductEntity(Product product) {
//        if (product == null) {
//            return null;
//        }
//
//        return ProductEntity.builder()
//                .id(product.getId())
//                .name(product.getName())
//                .description(product.getDescription())
//                .price(product.getPrice())
//                .category(product.getCategory())
//                .build();
//    }
//
//    private Product toProduct(ProductEntity productEntity) {
//        if (productEntity == null) {
//            return null;
//        }
//
//        return Product.builder()
//                .id(productEntity.getId())
//                .name(productEntity.getName())
//                .description(productEntity.getDescription())
//                .price(productEntity.getPrice())
//                .category(productEntity.getCategory())
//                .build();
//    }
//
//}
//
