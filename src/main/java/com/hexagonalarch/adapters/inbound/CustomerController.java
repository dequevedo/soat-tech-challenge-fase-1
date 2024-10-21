package com.hexagonalarch.adapters.inbound;

import com.hexagonalarch.application.dto.request.CreateCustomerRequest;
import com.hexagonalarch.application.dto.response.CreateCustomerResponse;
import com.hexagonalarch.application.dto.response.GetCustomerResponse;
import com.hexagonalarch.application.ports.inbound.CreateCustomerUseCase;
import com.hexagonalarch.application.ports.inbound.GetAllCustomersUseCase;
import com.hexagonalarch.application.ports.inbound.GetCustomerUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CreateCustomerUseCase createCustomerUseCase;

    private final GetCustomerUseCase getCustomerUseCase;

    private final GetAllCustomersUseCase getAllCustomersUseCase;

    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateCustomerResponse createCustomer(@Valid @RequestBody CreateCustomerRequest customer) {
        return createCustomerUseCase.createCustomer(customer);
    }

    @GetMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetCustomerResponse getCustomerById(@PathVariable Long id) {
        return getCustomerUseCase.getCustomerById(id);
    }

    @GetMapping("/customers")
    @ResponseStatus(HttpStatus.OK)
    public List<GetCustomerResponse> getAllCustomers() {
        return getAllCustomersUseCase.getAllCustomers();
    }

}