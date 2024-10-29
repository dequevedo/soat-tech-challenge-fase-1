package com.hexagonalarch.core.ports.in;

import com.hexagonalarch.adapters.dto.response.GetCustomerResponse;
import com.hexagonalarch.core.domain.Customer;

import java.util.List;

public interface GetAllCustomersUseCase {

    List<Customer> getAllCustomers();

}
