package br.com.tqi.evolution_test.resource.dto.request;

import br.com.tqi.evolution_test.config.validation.ValidateFirstInstallmentDate;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class LoanRequest {
    @NotNull
    private Double amount;
    @NotNull
    @ValidateFirstInstallmentDate
    private LocalDate firstInstallmentDate;
    @NotNull
    @Max(value = 60, message = "Number of installments can't be greater than 60")
    private Integer numberOfInstallments;
}
