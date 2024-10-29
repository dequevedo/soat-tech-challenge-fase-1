package com.hexagonalarch.config;

import com.hexagonalarch.adapters.inbound.ServicesFacade.CustomerServiceFacade;
import com.hexagonalarch.adapters.outbound.jpa.JpaCustomerRepository;
import com.hexagonalarch.adapters.outbound.jpa.JpaCustomerRepositoryAdapter;
import com.hexagonalarch.adapters.outbound.jpa.JpaProductRepository;
import com.hexagonalarch.core.ports.in.CreateCustomerUseCase;
import com.hexagonalarch.core.ports.in.GetAllCustomersUseCase;
import com.hexagonalarch.core.ports.in.GetCustomerUseCase;
import com.hexagonalarch.core.ports.out.CustomerRepositoryPort;
import com.hexagonalarch.core.service.CustomerService;
import com.hexagonalarch.core.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

//    @Bean
//    public CustomerRepositoryPort customerRepositoryPort(JpaCustomerRepository jpaCustomerRepository) {
//        return new JpaCustomerRepositoryAdapter(jpaCustomerRepository);
//    }

    @Bean
    public CustomerService customerService(CustomerRepositoryPort customerRepositoryPort) {
        return new CustomerService(customerRepositoryPort);
    }

    @Bean
    public CustomerServiceFacade customerServiceFacade(CreateCustomerUseCase customerService, GetCustomerUseCase getCustomerUseCase, GetAllCustomersUseCase getAllCustomersUseCase) {
        return new CustomerServiceFacade(customerService, getCustomerUseCase, getAllCustomersUseCase);
    }
//    @Bean
//    public CustomerServicePort UsuarioServiceImpl(UsuarioRepositoryPort usuarioRepositoryPort){
//        return new UsuarioService(usuarioRepositoryPort);
//    }
//
//    @Bean
//    public CustomerService customerService(final JpaCustomerRepositoryAdapter jpaCustomerRepositoryAdapter) {
//        return new CustomerService(jpaCustomerRepositoryAdapter);
//    }
//
//    @Bean
//    public JpaCustomerRepositoryAdapter jpaCustomerRepositoryAdapter(final JpaCustomerRepository jpaCustomerRepository) {
//        return new JpaCustomerRepositoryAdapter(jpaCustomerRepository);
//    }
//
//    @Bean
//    public JpaProductRepositoryAdapter jpaProductRepositoryAdapter(final JpaProductRepository jpaProductRepository) {
//        return new JpaProductRepositoryAdapter(jpaProductRepository);
//    }
//
//    @Bean
//    public ProductService productService(final JpaProductRepositoryAdapter jpaProductRepositoryAdapter) {
//        return new ProductService(jpaProductRepositoryAdapter);
//    }

}
