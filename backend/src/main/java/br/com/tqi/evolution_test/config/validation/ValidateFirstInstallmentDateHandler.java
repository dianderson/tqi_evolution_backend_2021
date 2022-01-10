package br.com.tqi.evolution_test.config.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class ValidateFirstInstallmentDateHandler implements ConstraintValidator<ValidateFirstInstallmentDate, LocalDate> {

    @Override
    public boolean isValid(LocalDate localDate, ConstraintValidatorContext constraintValidatorContext) {
        return LocalDate.now().plusMonths(3).isAfter(localDate);
    }
}
