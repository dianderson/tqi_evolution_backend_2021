package br.com.tqi.evolution_test.config;

import br.com.tqi.evolution_test.repository.CustomerRepository;
import br.com.tqi.evolution_test.repository.model.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class AuthenticationToken extends OncePerRequestFilter {

    private final MyTokenService myTokenService;
    private final CustomerRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = recoverToken(request);
        boolean valid = myTokenService.isValidToken(token);
        if (valid) {
            authenticateUser(token);
        }
        filterChain.doFilter(request, response);
    }

    private void authenticateUser(String token) {
        Long userId = myTokenService.getUserId(token);
        Customer user = userRepository.findById(userId).get();
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private String recoverToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
            return null;
        }
        return token.substring(7);
    }
}
