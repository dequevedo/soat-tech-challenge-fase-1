package com.hexagonalarch.adapters.inbound.ServicesFacade;

import com.hexagonalarch.core.domain.Customer;
import com.hexagonalarch.core.ports.in.CreateCustomerUseCase;
import com.hexagonalarch.core.ports.in.GetAllCustomersUseCase;
import com.hexagonalarch.core.ports.in.GetCustomerUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceFacade {

    private final CreateCustomerUseCase createCustomerUseCase;
    private final GetCustomerUseCase getCustomerUseCase;
    private final GetAllCustomersUseCase getAllCustomersUseCase;

    public CustomerServiceFacade(CreateCustomerUseCase createCustomerUseCase,
                                 GetCustomerUseCase getCustomerUseCase,
                                 GetAllCustomersUseCase getAllCustomersUseCase) {
        this.createCustomerUseCase = createCustomerUseCase;
        this.getCustomerUseCase = getCustomerUseCase;
        this.getAllCustomersUseCase = getAllCustomersUseCase;
    }

    public Customer createCustomer(Customer customer) {
        return createCustomerUseCase.createCustomer(customer);
    }

    public Customer getCustomerById(Long id) {
        return getCustomerUseCase.getCustomerById(id);
    }

    public List<Customer> getAllCustomers() {
        return getAllCustomersUseCase.getAllCustomers();
    }
}