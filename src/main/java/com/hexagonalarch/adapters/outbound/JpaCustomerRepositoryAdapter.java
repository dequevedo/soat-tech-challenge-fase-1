package com.hexagonalarch.adapters.outbound;

import com.hexagonalarch.adapters.outbound.entity.CustomerEntity;
import com.hexagonalarch.application.ports.outbound.CustomerOutboundPort;
import com.hexagonalarch.domain.Customer;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class JpaCustomerRepositoryAdapter implements CustomerOutboundPort {

    private final JpaCustomerRepository jpaRepository;

    @Override
    public Customer save(Customer customer) {
        CustomerEntity customerEntity = jpaRepository.save(toCustomerEntity(customer));
        return toCustomer(customerEntity);
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return jpaRepository.findById(id)
                .map(this::toCustomer);
    }

    @Override
    public List<Customer> findAll() {
        return jpaRepository.findAll().stream()
                .map(this::toCustomer)
                .toList();
    }

    private CustomerEntity toCustomerEntity(Customer customer) {
        if (customer == null) {
            return null;
        }

        return CustomerEntity.builder()
                .id(customer.getId())
                .name(customer.getName())
                .email(customer.getEmail())
                .build();
    }

    private Customer toCustomer(CustomerEntity customerEntity) {
        if (customerEntity == null) {
            return null;
        }

        return Customer.builder()
                .id(customerEntity.getId())
                .name(customerEntity.getName())
                .email(customerEntity.getEmail())
                .build();
    }
}

