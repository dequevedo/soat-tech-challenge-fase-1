package com.hexagonalarch.application.ports.inbound;

import com.hexagonalarch.application.dto.response.GetCustomerResponse;

import java.util.List;

public interface GetAllCustomersUseCase {

    List<GetCustomerResponse> getAllCustomers();

}
