package com.hexagonalarch.core.service.validations.customer;

import com.hexagonalarch.core.domain.Customer;
import com.hexagonalarch.core.service.validations.ValidationResult;
import com.hexagonalarch.core.service.validations.Validator;
import com.hexagonalarch.exception.BusinessException;

public class CustomerIsNotNullValidation implements Validator<Customer> {
    @Override
    public ValidationResult validate(Customer customer) {
        if (customer.getCpf() == null || customer.getCpf().isEmpty() && customer.getEmail() == null ||
            customer.getEmail().isEmpty() && customer.getName() == null || customer.getName().isEmpty()){
            throw new BusinessException("Cliente não identificado, dados estão nulos");
        }
        return new ValidationResult(true, "CPF válido");
    }
}
