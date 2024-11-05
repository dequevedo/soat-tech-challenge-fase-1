package com.hexagonalarch.core.service.validations.order;

import com.hexagonalarch.core.domain.Order;
import com.hexagonalarch.core.service.validations.ValidationResult;
import com.hexagonalarch.core.service.validations.Validator;
import com.hexagonalarch.exception.BusinessException;

public class MinimalProductQuantityValidation implements Validator<Order> {

    @Override
    public ValidationResult validate(Order order) {
        if (order.getProducts().isEmpty()) {
            throw new BusinessException("Order must contain at least one product.");
        }

        return new ValidationResult(true, "Order contains at least one product.");
    }
}

