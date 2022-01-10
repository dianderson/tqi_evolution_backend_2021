package br.com.tqi.evolution_test.resource;

import br.com.tqi.evolution_test.resource.dto.request.LoanRequest;
import br.com.tqi.evolution_test.resource.dto.response.LoanDetailedResponse;
import br.com.tqi.evolution_test.resource.dto.response.LoanResponse;
import br.com.tqi.evolution_test.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/loan")
public class LoanResource {

    private final LoanService loanService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public LoanResponse create(@RequestBody @Valid LoanRequest request, @RequestHeader("Authorization") String token) {
        return loanService.create(request, token.substring(7));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<LoanResponse> findAllByCustomer(@RequestHeader("Authorization") String token) {
        return loanService.findAllByCustomerId(token.substring(7));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LoanDetailedResponse findById(@PathVariable Long id) {
        return loanService.findById(id);
    }
}
