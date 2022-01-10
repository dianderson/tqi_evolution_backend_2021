package br.com.tqi.evolution_test.resource.dto.response;

import br.com.tqi.evolution_test.repository.model.Customer;
import lombok.Data;

@Data
public class LoginResponse {
    private String username;
    private String roleDescription;
    private String token;
    private String type;

    public static LoginResponse of(Customer customer, String token, String tokenType) {
        var response = new LoginResponse();
        response.setUsername(customer.getUsername());
        response.setRoleDescription(customer.getRoles().get(0).getDescription());
        response.setToken(token);
        response.setType(tokenType);
        return response;
    }
}
