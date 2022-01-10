package br.com.tqi.evolution_test.resource.dto.request;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class LoanRequest {
    @NotNull
    private Double amount;
    @NotNull
    private LocalDate firstInstallmentDate;
    @NotNull
    @Max(value = 60, message = "Number of installments can't be greater than 60")
    private Integer numberOfInstallments;
}
