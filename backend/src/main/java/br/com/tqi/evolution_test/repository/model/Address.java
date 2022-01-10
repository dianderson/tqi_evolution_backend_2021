package br.com.tqi.evolution_test.repository.model;

import br.com.tqi.evolution_test.resource.dto.request.AddressRequest;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Data
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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

    public static Address of(AddressRequest addressRequest) {
        var address = new Address();
        address.setStreetName(addressRequest.getStreetName());
        address.setNumber(addressRequest.getNumber());
        address.setZipCode(addressRequest.getZipCode());
        address.setNeighborhood(addressRequest.getNeighborhood());
        address.setCity(addressRequest.getCity());
        address.setCountry(addressRequest.getCountry());
        return address;
    }
}
