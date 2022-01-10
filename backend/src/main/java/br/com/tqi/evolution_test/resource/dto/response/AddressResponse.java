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
        var addressResponse = new AddressResponse();
        addressResponse.setStreetName(address.getStreetName());
        addressResponse.setNumber(address.getNumber());
        addressResponse.setZipCode(address.getZipCode());
        addressResponse.setNeighborhood(address.getNeighborhood());
        addressResponse.setCity(address.getCity());
        addressResponse.setCountry(address.getCountry());
        return addressResponse;
    }
}
