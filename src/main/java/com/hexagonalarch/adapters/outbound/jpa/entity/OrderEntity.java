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

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @ManyToMany
    @JoinTable(
            name = "order_entity_snack",
            joinColumns = @JoinColumn(name = "order_entity_id"),
            inverseJoinColumns = @JoinColumn(name = "snack_id")
    )
    private List<ProductEntity> snacks;

    @ManyToMany
    @JoinTable(
            name = "order_entity_side",
            joinColumns = @JoinColumn(name = "order_entity_id"),
            inverseJoinColumns = @JoinColumn(name = "side_id")
    )
    private List<ProductEntity> sides;

    @ManyToMany
    @JoinTable(
            name = "order_entity_drink",
            joinColumns = @JoinColumn(name = "order_entity_id"),
            inverseJoinColumns = @JoinColumn(name = "drink_id")
    )
    private List<ProductEntity> drinks;

    @ManyToMany
    @JoinTable(
            name = "order_entity_dessert",
            joinColumns = @JoinColumn(name = "order_entity_id"),
            inverseJoinColumns = @JoinColumn(name = "dessert_id")
    )
    private List<ProductEntity> desserts;

    private Double totalPrice;

}