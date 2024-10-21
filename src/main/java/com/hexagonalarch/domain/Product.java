package com.hexagonalarch.domain;

import lombok.*;

@Data
@AllArgsConstructor
public class Product {

    private Long id;
    private String name;
    private Double price;

}