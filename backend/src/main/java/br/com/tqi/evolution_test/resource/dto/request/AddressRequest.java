package br.com.tqi.evolution_test.resource.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AddressRequest {
    @NotBlank
    private String streetName;
    @NotBlank
    private String number;
    @NotBlank
    private String zipCode;
    @NotBlank
    private String neighborhood;
    @NotBlank
    private String city;
    @NotBlank
    private String country;
}
