package com.hexagonalarch.application.ports.inbound;

import com.hexagonalarch.application.dto.response.GetCustomerResponse;

public interface GetCustomerUseCase {

    GetCustomerResponse getCustomerById(Long id);

}
