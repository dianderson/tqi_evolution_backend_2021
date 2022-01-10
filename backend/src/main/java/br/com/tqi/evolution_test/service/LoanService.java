package br.com.tqi.evolution_test.service;

import br.com.tqi.evolution_test.config.MyTokenService;
import br.com.tqi.evolution_test.repository.CustomerRepository;
import br.com.tqi.evolution_test.repository.LoanRepository;
import br.com.tqi.evolution_test.repository.model.Loan;
import br.com.tqi.evolution_test.resource.dto.request.LoanRequest;
import br.com.tqi.evolution_test.resource.dto.response.LoanDetailedResponse;
import br.com.tqi.evolution_test.resource.dto.response.LoanResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanService {

    private final LoanRepository loanRepository;
    private final CustomerRepository customerRepository;
    private final MyTokenService myTokenService;

    public LoanResponse create(LoanRequest request, String token) {
        Long userId = myTokenService.getUserId(token);
        var customer = customerRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Entity with id %s not found", userId)));
        return LoanResponse.of(loanRepository.save(Loan.of(request, customer)));
    }

    public List<LoanResponse> findAllByCustomerId(String token) {
        return loanRepository.findAllByCustomerId(myTokenService.getUserId(token));
    }

    public LoanDetailedResponse findById(Long id) {
        return loanRepository.findById(id)
                .map(LoanDetailedResponse::of)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Loan with id %s not found", id)));
    }
}
