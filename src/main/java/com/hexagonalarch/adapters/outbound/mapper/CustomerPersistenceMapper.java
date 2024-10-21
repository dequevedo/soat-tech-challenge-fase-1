package com.hexagonalarch.adapters.outbound.mapper;

import com.hexagonalarch.adapters.outbound.entity.CustomerEntity;
import com.hexagonalarch.domain.Customer;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerPersistenceMapper {

    CustomerEntity toCustomerEntity(Customer customer);

    Customer toCustomer(CustomerEntity customerEntity);

}
