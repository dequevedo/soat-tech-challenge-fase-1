package com.hexagonalarch.adapters.outbound.entity;

import com.hexagonalarch.domain.enumeration.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private CustomerEntity customer;

    @OneToMany
    private List<ProductEntity> products;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private Double totalPrice;

    public Double getTotalPrice() {
        return products.stream()
                .mapToDouble(ProductEntity::getPrice)
                .sum();
    }

}