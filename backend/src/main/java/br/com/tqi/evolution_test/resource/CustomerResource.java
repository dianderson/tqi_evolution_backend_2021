package br.com.tqi.evolution_test.resource;

import br.com.tqi.evolution_test.repository.model.Customer;
import br.com.tqi.evolution_test.resource.dto.request.CustomerRequest;
import br.com.tqi.evolution_test.resource.dto.response.CustomerResponse;
import br.com.tqi.evolution_test.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerResource {

    private final CustomerService customerService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerResponse create(@RequestBody @Valid CustomerRequest request) {
        return customerService.create(Customer.of(request));
    }
}