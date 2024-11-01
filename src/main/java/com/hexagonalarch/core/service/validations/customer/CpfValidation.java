package com.hexagonalarch.core.service.validations.customer;

import com.hexagonalarch.core.domain.Customer;
import com.hexagonalarch.core.service.validations.ValidationResult;
import com.hexagonalarch.core.service.validations.Validator;
import com.hexagonalarch.exception.BusinessException;

public class CpfValidation implements Validator<Customer> {
    @Override
    public ValidationResult validate(Customer customer) {
        if (customer.getCpf() == null || customer.getCpf().isEmpty()) {
            return new ValidationResult(false, "Todos os campos (CPF, Nome e Email) são obrigatórios.");
        }
        return new ValidationResult(true, null);
    }
}