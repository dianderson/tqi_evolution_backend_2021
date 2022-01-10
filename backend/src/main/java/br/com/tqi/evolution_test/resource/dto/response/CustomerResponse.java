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
        var response = new CustomerResponse();
        response.setId(customer.getId());
        response.setName(customer.getName());
        response.setEmail(customer.getEmail());
        response.setCpf(customer.getCpf());
        response.setRg(customer.getRg());
        response.setAddressResponse(AddressResponse.of(customer.getAddress()));
        response.setIncome(customer.getIncome());
        response.setRoleDescription(customer.getRoles().get(0).getDescription());
        return response;
    }
}
