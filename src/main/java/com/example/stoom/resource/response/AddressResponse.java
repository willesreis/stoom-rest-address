package com.example.stoom.resource.response;

import com.example.stoom.entity.Address;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * AddressResponse
 */
@JsonInclude(value = Include.NON_NULL)
public class AddressResponse {
    
    private Long id;
    private String streetName;
    private Integer number;
    private String complement;
    private String neighbourhood;
    private String city;
    private String state;
    private String country;
    private String zipcode;
    private String latitude;
    private String longitude;

    public AddressResponse(Address entity) {
        this.id = entity.getId();
        this.streetName = entity.getStreetName();
        this.number = entity.getNumber();
        this.complement = entity.getComplement();
        this.neighbourhood = entity.getNeighbourhood();
        this.city = entity.getCity();
        this.state = entity.getState();
        this.country = entity.getCountry();
        this.zipcode = entity.getZipcode();
        this.latitude = entity.getLatitude();
        this.longitude = entity.getLongitude();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

}
