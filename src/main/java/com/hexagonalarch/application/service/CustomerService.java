package com.hexagonalarch.application.service;

import com.hexagonalarch.application.dto.request.CreateCustomerRequest;
import com.hexagonalarch.application.dto.response.CreateCustomerResponse;
import com.hexagonalarch.application.dto.response.GetCustomerResponse;
import com.hexagonalarch.application.ports.inbound.CreateCustomerUseCase;
import com.hexagonalarch.application.ports.inbound.GetAllCustomersUseCase;
import com.hexagonalarch.application.ports.inbound.GetCustomerUseCase;
import com.hexagonalarch.application.ports.outbound.CustomerOutboundPort;
import com.hexagonalarch.domain.Customer;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class CustomerService implements CreateCustomerUseCase, GetCustomerUseCase, GetAllCustomersUseCase {

    private final CustomerOutboundPort customerRepository;

    @Override
    public CreateCustomerResponse createCustomer(CreateCustomerRequest createCustomerRequest) {
        Customer customer = Customer.valueOf(createCustomerRequest);

        Customer storedCustomer = customerRepository.save(customer);

        return CreateCustomerResponse.valueOf(storedCustomer);
    }

    @Override
    public GetCustomerResponse getCustomerById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        Customer storedCustomer = customer.orElseThrow(() -> new RuntimeException("Customer not found"));

        return GetCustomerResponse.valueOf(storedCustomer);
    }

    @Override
    public List<GetCustomerResponse> getAllCustomers() {
        return customerRepository.findAll().stream().map(GetCustomerResponse::valueOf).toList();
    }
}
