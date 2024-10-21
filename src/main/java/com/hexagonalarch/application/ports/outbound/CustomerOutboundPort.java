package com.hexagonalarch.application.ports.outbound;

import com.hexagonalarch.domain.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerOutboundPort {

    Customer save(Customer product);

    Optional<Customer> findById(Long id);

    List<Customer> findAll();

}