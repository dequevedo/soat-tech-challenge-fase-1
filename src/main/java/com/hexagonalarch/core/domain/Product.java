package com.hexagonalarch.core.domain;

import com.hexagonalarch.core.domain.enumeration.ProductCategory;

public class Product {

    private Long id;

    private String name;

    private String description;

    private Double price;

    private ProductCategory category;

    public Product() {
    }

    public Product(Long id) {
        this.id = id;
    }

    public Product(Long id, String name, String description, Double price, ProductCategory category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }
}