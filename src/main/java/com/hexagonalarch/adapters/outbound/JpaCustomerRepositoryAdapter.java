package com.hexagonalarch.adapters.outbound;

import com.hexagonalarch.adapters.outbound.entity.CustomerEntity;
import com.hexagonalarch.adapters.outbound.mapper.CustomerPersistenceMapper;
import com.hexagonalarch.application.ports.outbound.CustomerOutboundPort;
import com.hexagonalarch.domain.Customer;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class JpaCustomerRepositoryAdapter implements CustomerOutboundPort {

    private final JpaCustomerRepository jpaRepository;

    private final CustomerPersistenceMapper customerPersistenceMapper;

    @Override
    public Customer save(Customer customer) {
        CustomerEntity customerEntity = jpaRepository.save(customerPersistenceMapper.toCustomerEntity(customer));
        return customerPersistenceMapper.toCustomer(customerEntity);
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return jpaRepository.findById(id)
                .map(customerPersistenceMapper::toCustomer);
    }

    @Override
    public List<Customer> findAll() {
        return jpaRepository.findAll().stream()
                .map(customerPersistenceMapper::toCustomer)
                .toList();
    }

}

