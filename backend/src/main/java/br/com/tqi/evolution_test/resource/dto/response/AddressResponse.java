package br.com.tqi.evolution_test.resource.dto.response;

import br.com.tqi.evolution_test.repository.model.Address;
import lombok.Data;

@Data
public class AddressResponse {
    private String streetName;
    private String number;
    private String zipCode;
    private String neighborhood;
    private String city;
    private String country;

    public static AddressResponse of(Address address) {
        var response = new AddressResponse();
        response.setStreetName(address.getStreetName());
        response.setNumber(address.getNumber());
        response.setZipCode(address.getZipCode());
        response.setNeighborhood(address.getNeighborhood());
        response.setCity(address.getCity());
        response.setCountry(address.getCountry());
        return response;
    }
}
