package br.com.tqi.evolution_test.repository.model;

import br.com.tqi.evolution_test.resource.dto.request.LoanRequest;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Entity
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @ManyToOne
    private Customer customer;
    @NotNull
    private Double amount;
    @NotNull
    private LocalDate firstInstallmentDate;
    @NotNull
    @Max(value = 60, message = "Number of installments can't be greater than 60")
    private Integer numberOfInstallments;

    public static Loan of(LoanRequest request, Customer customer) {
        if (request.getFirstInstallmentDate().isAfter(LocalDate.now().plusMonths(3))) {
            throw new IllegalArgumentException(String.format("First Installment Date not be more than %s", LocalDate.now().plusMonths(3)));
        } else {
            var loan = new Loan();
            loan.setCustomer(customer);
            loan.setAmount(request.getAmount());
            loan.setFirstInstallmentDate(request.getFirstInstallmentDate());
            loan.setNumberOfInstallments(request.getNumberOfInstallments());
            return loan;
        }
    }
}
