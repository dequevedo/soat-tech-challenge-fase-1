package com.hexagonalarch.domain;

import com.hexagonalarch.domain.enumeration.ProductCategory;
import lombok.*;

@Data
@AllArgsConstructor
public class Product {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private ProductCategory category;

}