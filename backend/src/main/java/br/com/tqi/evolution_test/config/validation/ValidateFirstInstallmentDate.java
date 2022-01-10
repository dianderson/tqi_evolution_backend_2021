package br.com.tqi.evolution_test.config.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ValidateFirstInstallmentDateHandler.class)
public @interface ValidateFirstInstallmentDate {

    String message() default "First Installment Date can't be greater than 3 months";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
