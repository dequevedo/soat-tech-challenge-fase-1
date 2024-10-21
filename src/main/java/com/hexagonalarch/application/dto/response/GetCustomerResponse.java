package com.hexagonalarch.application.dto.response;

import com.hexagonalarch.domain.Customer;
import com.hexagonalarch.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetCustomerResponse {

    private Long id;

    private String name;

    private String email;

    private String cpf;

    public static GetCustomerResponse valueOf(Customer customer) {
        return GetCustomerResponse.builder()
                .id(customer.getId())
                .name(customer.getName())
                .email(customer.getEmail())
                .cpf(customer.getCpf())
                .build();
    }

}