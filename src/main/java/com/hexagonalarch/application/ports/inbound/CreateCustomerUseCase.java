package com.hexagonalarch.application.ports.inbound;

import com.hexagonalarch.application.dto.request.CreateCustomerRequest;
import com.hexagonalarch.application.dto.response.CreateCustomerResponse;

public interface CreateCustomerUseCase {

    CreateCustomerResponse createCustomer(CreateCustomerRequest createCustomerRequest);

}
