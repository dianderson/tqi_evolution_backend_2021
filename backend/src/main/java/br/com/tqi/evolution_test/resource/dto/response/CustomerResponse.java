package br.com.tqi.evolution_test.resource.dto.response;

import br.com.tqi.evolution_test.repository.model.Customer;
import lombok.Data;

@Data
public class CustomerResponse {
    private Long id;
    private String name;
    private String email;
    private String cpf;
    private String rg;
    private AddressResponse addressResponse;
    private Double income;
    private String roleDescription;

    public static CustomerResponse of(Customer customer) {
        var customerResponse = new CustomerResponse();
        customerResponse.setId(customer.getId());
        customerResponse.setName(customer.getName());
        customerResponse.setEmail(customer.getEmail());
        customerResponse.setCpf(customer.getCpf());
        customerResponse.setRg(customer.getRg());
        customerResponse.setAddressResponse(AddressResponse.of(customer.getAddress()));
        customerResponse.setIncome(customer.getIncome());
        customerResponse.setRoleDescription(customer.getRoles().get(0).getDescription());
        return customerResponse;
    }
}
