package com.hexagonalarch.adapters.outbound.jpa.entity;

import com.hexagonalarch.core.domain.enumeration.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
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