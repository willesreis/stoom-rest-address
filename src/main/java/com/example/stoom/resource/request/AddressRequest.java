package com.example.stoom.resource.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.example.stoom.entity.Address;

/**
 * AddressRequest
 */
public class AddressRequest {
    
    @NotBlank
    private String streetName;
    @Min(0)
    @NotNull
    private Integer number;
    private String complement;
    @NotBlank
    private String neighbourhood;
    @NotBlank
    private String city;
    @NotBlank
    private String state;
    @NotBlank
    private String country;
    @Pattern(regexp = "\\d{5}-\\d{3}")
    @NotBlank
    private String zipcode;
    private String latitude;
    private String longitude;

    public AddressRequest() {
        super();
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getNeighbourhood() {
        return neighbourhood;
    }

    public void setNeighbourhood(String neighbourhood) {
        this.neighbourhood = neighbourhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Address toEntity(Long id) {
        Address entity = new Address(id, this.streetName, this.number, this.neighbourhood, this.city, this.state, this.country, this.zipcode);
        entity.setComplement(this.complement);
        entity.setLatitude(this.latitude);
        entity.setLongitude(this.longitude);
        return entity;
    }

}
