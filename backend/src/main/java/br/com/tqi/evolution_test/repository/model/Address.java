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

    public static Address of(AddressRequest request) {
        var address = new Address();
        address.setStreetName(request.getStreetName());
        address.setNumber(request.getNumber());
        address.setZipCode(request.getZipCode());
        address.setNeighborhood(request.getNeighborhood());
        address.setCity(request.getCity());
        address.setCountry(request.getCountry());
        return address;
    }
}
