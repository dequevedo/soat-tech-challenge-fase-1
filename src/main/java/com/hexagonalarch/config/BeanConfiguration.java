package com.hexagonalarch.config;

import com.hexagonalarch.adapters.outbound.JpaCustomerRepository;
import com.hexagonalarch.adapters.outbound.JpaCustomerRepositoryAdapter;
import com.hexagonalarch.adapters.outbound.JpaProductRepository;
import com.hexagonalarch.adapters.outbound.JpaProductRepositoryAdapter;
import com.hexagonalarch.adapters.outbound.mapper.CustomerPersistenceMapper;
import com.hexagonalarch.adapters.outbound.mapper.ProductPersistenceMapper;
import com.hexagonalarch.application.service.CustomerService;
import com.hexagonalarch.application.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public JpaCustomerRepositoryAdapter jpaCustomerRepositoryAdapter(final JpaCustomerRepository jpaCustomerRepository, final CustomerPersistenceMapper customerPersistenceMapper) {
        return new JpaCustomerRepositoryAdapter(jpaCustomerRepository, customerPersistenceMapper);
    }

    @Bean
    public JpaProductRepositoryAdapter jpaProductRepositoryAdapter(final JpaProductRepository jpaProductRepository, final ProductPersistenceMapper productPersistenceMapper) {
        return new JpaProductRepositoryAdapter(jpaProductRepository, productPersistenceMapper);
    }

    @Bean
    public CustomerService customerService(final JpaCustomerRepositoryAdapter jpaCustomerRepositoryAdapter) {
        return new CustomerService(jpaCustomerRepositoryAdapter);
    }

    @Bean
    public ProductService productService(final JpaProductRepositoryAdapter jpaProductRepositoryAdapter) {
        return new ProductService(jpaProductRepositoryAdapter);
    }

}
