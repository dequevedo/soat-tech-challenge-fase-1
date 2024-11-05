package com.hexagonalarch.core.service.validations.order;

import com.hexagonalarch.core.domain.Order;
import com.hexagonalarch.core.service.validations.ValidationResult;
import com.hexagonalarch.core.service.validations.Validator;
import com.hexagonalarch.exception.BusinessException;

public class MinimalProductQuantityValidation implements Validator<Order> {

    @Override
    public ValidationResult validate(Order order) {
        if (!hasAtLeastOneProduct(order)) {
            throw new BusinessException("Order must contain at least one product from any category: snacks, sides, drinks, or desserts.");
        }

        return new ValidationResult(true, "Order contains at least one product.");
    }

    private boolean hasAtLeastOneProduct(Order order) {
        return (order.getSnacks() != null && !order.getSnacks().isEmpty()) ||
                (order.getSides() != null && !order.getSides().isEmpty()) ||
                (order.getDrinks() != null && !order.getDrinks().isEmpty()) ||
                (order.getDesserts() != null && !order.getDesserts().isEmpty());
    }
}

