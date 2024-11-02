package com.hexagonalarch.core.service;
import com.hexagonalarch.core.ports.in.Customer.CreateCustomerUseCase;
import com.hexagonalarch.core.ports.in.Customer.GetAllCustomersUseCase;
import com.hexagonalarch.core.ports.in.Customer.GetCustomerUseCase;
import com.hexagonalarch.core.ports.in.Customer.IdentifyOrCreateCustomerUseCase;
import com.hexagonalarch.core.ports.out.CustomerRepositoryPort;
import com.hexagonalarch.core.domain.Customer;
import com.hexagonalarch.core.service.validations.ValidationResult;
import com.hexagonalarch.core.service.validations.Validator;
import com.hexagonalarch.core.service.validations.customer.CpfValidation;
import com.hexagonalarch.core.service.validations.factory.CostumerValidationFactory;
import com.hexagonalarch.exception.BusinessException;

import java.util.List;
import java.util.Optional;

public class CustomerService implements CreateCustomerUseCase, GetCustomerUseCase, GetAllCustomersUseCase, IdentifyOrCreateCustomerUseCase {

    private final CustomerRepositoryPort customerRepository;

    public CustomerService(CustomerRepositoryPort customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        Customer storedCustomer = customer.orElseThrow(() -> new RuntimeException("Customer not found"));

        return storedCustomer;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer identifyOrCreateCustomer(Customer c) {
        ValidationResult validate = CostumerValidationFactory.getValidatorsForIdentify().validate(c);
        if(!validate.isValid()){
            throw new BusinessException(validate.getMessage());
        }
        return new Customer( Integer.toUnsignedLong(21212), "kdfllfdl","dsldsçlsdçl", "834348834");
    }
}
