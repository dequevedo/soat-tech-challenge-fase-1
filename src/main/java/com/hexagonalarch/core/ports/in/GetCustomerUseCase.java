package com.hexagonalarch.core.ports.in;

import com.hexagonalarch.adapters.dto.response.GetCustomerResponse;
import com.hexagonalarch.core.domain.Customer;

public interface GetCustomerUseCase {

    Customer getCustomerById(Long id);

}
