package br.com.tqi.evolution_test.service;

import br.com.tqi.evolution_test.config.MyTokenService;
import br.com.tqi.evolution_test.repository.CustomerRepository;
import br.com.tqi.evolution_test.repository.model.Customer;
import br.com.tqi.evolution_test.resource.dto.response.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class LoginService {

    private static final String TOKEN_TYPE = "Bearer";
    private final CustomerRepository customerRepository;
    private final AuthenticationManager authenticationManager;
    private final MyTokenService myTokenService;

    public LoginResponse authentication(UsernamePasswordAuthenticationToken request) {
        Authentication authentication = authenticationManager.authenticate(request);
        String token = myTokenService.createToken(authentication);
        Customer user = customerRepository.findByEmail(request.getName())
                .orElseThrow(() -> new EntityNotFoundException(String.format("User %s not found", request.getName())));
        return LoginResponse.of(user, token, "TOKEN_TYPE");
    }
}
