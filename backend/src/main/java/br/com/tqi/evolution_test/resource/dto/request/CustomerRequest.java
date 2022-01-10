package br.com.tqi.evolution_test.resource.dto.request;

import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CustomerRequest {
    @NotBlank
    private String name;
    @Email
    @NotBlank
    private String email;
    @CPF
    @NotBlank
    private String cpf;
    @NotBlank
    private String rg;
    @Valid
    @NotNull
    private AddressRequest address;
    @NotNull
    private Double income;
    @NotBlank
    private String password;
    @NotBlank
    private String roleName;
}
