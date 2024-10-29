package com.hexagonalarch.adapters.converters;

import com.hexagonalarch.adapters.dto.CustomerDto;
import com.hexagonalarch.core.domain.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerConverter {
    public Customer toDomain(CustomerDto customerDto){
        return new Customer(customerDto.getId(), customerDto.getName(),
                customerDto.getEmail(), customerDto.getCpf());
    }

    public CustomerDto toDto(Customer customer){
        return new CustomerDto(customer.getId(), customer.getName(),
                customer.getEmail(), customer.getCpf());
    }
}
