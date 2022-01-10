package br.com.tqi.evolution_test.resource.dto.response;

import br.com.tqi.evolution_test.repository.model.Loan;
import lombok.Data;

import java.time.LocalDate;

@Data
public class LoanResponse {
    private Long id;
    private Double amount;
    private LocalDate firstInstallmentDate;
    private Integer numberOfInstallments;

    public static LoanResponse of(Loan loan) {
        var loanResponse = new LoanResponse();
        loanResponse.setId(loan.getId());
        loanResponse.setAmount(loan.getAmount());
        loanResponse.setFirstInstallmentDate(loan.getFirstInstallmentDate());
        loanResponse.setNumberOfInstallments(loan.getNumberOfInstallments());
        return loanResponse;
    }
}
