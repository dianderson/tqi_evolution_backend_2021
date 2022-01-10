package br.com.tqi.evolution_test.resource.dto.response;

import br.com.tqi.evolution_test.repository.model.Loan;
import lombok.Data;

import java.time.LocalDate;

@Data
public class LoanDetailedResponse {
    private Long id;
    private Double amount;
    private LocalDate firstInstallmentDate;
    private Integer numberOfInstallments;
    private String email;
    private Double income;

    public static LoanDetailedResponse of(Loan loan) {
        var loanDetailedResponse = new LoanDetailedResponse();
        loanDetailedResponse.setId(loan.getId());
        loanDetailedResponse.setAmount(loan.getAmount());
        loanDetailedResponse.setFirstInstallmentDate(loan.getFirstInstallmentDate());
        loanDetailedResponse.setNumberOfInstallments(loan.getNumberOfInstallments());
        loanDetailedResponse.setEmail(loan.getCustomer().getEmail());
        loanDetailedResponse.setIncome(loan.getCustomer().getIncome());
        return loanDetailedResponse;
    }
}
