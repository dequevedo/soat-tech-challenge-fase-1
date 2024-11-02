package com.hexagonalarch.core.service.validations.factory;

import com.hexagonalarch.core.domain.Customer;
import com.hexagonalarch.core.service.validations.CompositeValidator;
import com.hexagonalarch.core.service.validations.Validator;
import com.hexagonalarch.core.service.validations.customer.CpfValidation;
import com.hexagonalarch.core.service.validations.customer.CustomerIsNotNullValidation;

import java.util.List;

public class CostumerValidationFactory {

    public static Validator<Customer> getValidatorsForIdentify() {
        return new CompositeValidator<>(List.of(
                new CustomerIsNotNullValidation(),
                new CpfValidation()
        ));
    }
}
