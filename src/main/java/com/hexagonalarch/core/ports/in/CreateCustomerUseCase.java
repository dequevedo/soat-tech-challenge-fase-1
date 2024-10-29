package com.hexagonalarch.core.ports.in;

import com.hexagonalarch.adapters.dto.request.CreateCustomerRequest;
import com.hexagonalarch.adapters.dto.response.CreateCustomerResponse;
import com.hexagonalarch.core.domain.Customer;

public interface CreateCustomerUseCase {

    Customer createCustomer(Customer customer);

}
