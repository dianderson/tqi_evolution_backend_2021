package br.com.tqi.evolution_test.repository;

import br.com.tqi.evolution_test.repository.model.Loan;
import br.com.tqi.evolution_test.resource.dto.response.LoanResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
    List<LoanResponse> findAllByCustomerId(Long id);
}
