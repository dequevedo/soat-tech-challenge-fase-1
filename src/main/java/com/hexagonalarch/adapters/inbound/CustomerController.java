package com.hexagonalarch.adapters.inbound;

import com.hexagonalarch.adapters.converters.CustomerConverter;
import com.hexagonalarch.adapters.dto.CustomerDto;
import com.hexagonalarch.adapters.dto.request.CreateCustomerRequest;
import com.hexagonalarch.adapters.dto.response.CreateCustomerResponse;
import com.hexagonalarch.adapters.dto.response.GetCustomerResponse;
import com.hexagonalarch.adapters.inbound.ServicesFacade.CustomerServiceFacade;
import com.hexagonalarch.core.domain.Customer;
import com.hexagonalarch.core.ports.in.CreateCustomerUseCase;
import com.hexagonalarch.core.ports.in.GetAllCustomersUseCase;
import com.hexagonalarch.core.ports.in.GetCustomerUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerServiceFacade customerServiceFacade;
    private final CustomerConverter customerConverter;

    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDto createCustomer(@Valid @RequestBody CustomerDto customerDto) {
        Customer customer = customerServiceFacade.createCustomer(customerConverter.toDomain(customerDto));
        return customerConverter.toDto(customer);
    }

    @GetMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDto getCustomerById(@PathVariable Long id) {
        Customer customer = customerServiceFacade.getCustomerById(id);
        return customerConverter.toDto(customer);
    }

    @GetMapping("/customers")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerDto> getAllCustomers() {
        return customerServiceFacade.getAllCustomers()
                .stream()
                .map(customerConverter::toDto)
                .toList();
    }

}