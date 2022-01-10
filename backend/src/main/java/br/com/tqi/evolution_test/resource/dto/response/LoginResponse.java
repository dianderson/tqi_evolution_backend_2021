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
        var loginResponse = new LoginResponse();
        loginResponse.setUsername(customer.getUsername());
        loginResponse.setRoleDescription(customer.getRoles().get(0).getDescription());
        loginResponse.setToken(token);
        loginResponse.setType(tokenType);
        return loginResponse;
    }
}
