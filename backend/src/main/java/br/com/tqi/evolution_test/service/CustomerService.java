package br.com.tqi.evolution_test.service;

import br.com.tqi.evolution_test.repository.CustomerRepository;
import br.com.tqi.evolution_test.repository.model.Customer;
import br.com.tqi.evolution_test.resource.dto.response.CustomerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerResponse create(Customer customer) {
        return CustomerResponse.of(customerRepository.save(customer));
    }
}
