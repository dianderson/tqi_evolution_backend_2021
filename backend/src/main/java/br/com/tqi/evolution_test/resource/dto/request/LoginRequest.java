package br.com.tqi.evolution_test.resource.dto.request;

import lombok.Data;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.validation.constraints.NotBlank;

@Data
public class LoginRequest {
    @NotBlank
    private String username;
    @NotBlank
    private String password;

    public UsernamePasswordAuthenticationToken of() {
        return new UsernamePasswordAuthenticationToken(username, password);
    }
}
