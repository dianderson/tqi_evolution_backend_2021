package br.com.tqi.evolution_test.resource;

import br.com.tqi.evolution_test.resource.dto.request.LoginRequest;
import br.com.tqi.evolution_test.resource.dto.response.LoginResponse;
import br.com.tqi.evolution_test.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class LoginResource {

    private final LoginService loginService;

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public LoginResponse authentication(@RequestBody @Valid LoginRequest request) {
        return loginService.authentication(request.createUsernamePasswordAuthenticationToken());
    }
}
