package com.hexagonalarch.core.service.validations.order;

import com.hexagonalarch.core.domain.Order;
import com.hexagonalarch.core.domain.Product;
import com.hexagonalarch.core.domain.enumeration.ProductCategory;
import com.hexagonalarch.core.service.validations.ValidationResult;
import com.hexagonalarch.core.service.validations.Validator;
import com.hexagonalarch.exception.BusinessException;

import java.util.List;

public class ProductsCategoriesValidation implements Validator<Order> {

    @Override
    public ValidationResult validate(Order order) {
        if (hasInvalidCategory(order.getSnack(), ProductCategory.LANCHE)) {
            throw new BusinessException("Invalid products found in 'snack' category.");
        }

        if (hasInvalidCategory(order.getSide(), ProductCategory.ACOMPANHAMENTO)) {
            throw new BusinessException("Invalid products found in 'side' category.");
        }

        if (hasInvalidCategory(order.getDrink(), ProductCategory.BEBIDA)) {
            throw new BusinessException("Invalid products found in 'drink' category.");
        }

        if (hasInvalidCategory(order.getDessert(), ProductCategory.SOBREMESA)) {
            throw new BusinessException("Invalid products found in 'dessert' category.");
        }

        return new ValidationResult(true, "Product categories are valid.");
    }

    private boolean hasInvalidCategory(List<Product> products, ProductCategory expectedCategory) {
        return products != null && products.stream()
                .anyMatch(product -> product.getCategory() != expectedCategory);
    }
}
