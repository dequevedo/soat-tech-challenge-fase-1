package com.hexagonalarch.adapters.dto.response;

import com.hexagonalarch.core.domain.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateCustomerResponse {

    private Long id;

    private String name;

    private String email;

    private String cpf;

    public static CreateCustomerResponse valueOf(Customer customer) {
        return CreateCustomerResponse.builder()
                .id(customer.getId())
                .name(customer.getName())
                .email(customer.getEmail())
                .cpf(customer.getCpf())
                .build();
    }

}