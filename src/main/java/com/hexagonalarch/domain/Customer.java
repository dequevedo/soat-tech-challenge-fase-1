package com.hexagonalarch.domain;

import com.hexagonalarch.application.dto.request.CreateCustomerRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    private Long id;
    private String name;
    private String email;
    private String cpf;

    public static Customer valueOf(CreateCustomerRequest createCustomerRequest) {
        return Customer.builder()
                .name(createCustomerRequest.getName())
                .email(createCustomerRequest.getEmail())
                .cpf(createCustomerRequest.getCpf())
                .build();
    }

}