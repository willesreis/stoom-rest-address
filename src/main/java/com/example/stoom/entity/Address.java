package com.example.stoom.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Address
 */
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long id;
    @NotBlank
    private String streetName;
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
    @NotBlank
    private String zipcode;
    private String latitude;
    private String longitude;

    public Address() {
        super();
    }

    public Address(Long id, String streetName, Integer number, String neighbourhood, String city, String state,
            String country, String zipcode) {
        super();
        this.id = id;
        this.streetName = streetName;
        this.number = number;
        this.neighbourhood = neighbourhood;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipcode = zipcode;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the streetName
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * @return the number
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * @return the complement
     */
    public String getComplement() {
        return complement;
    }

    /**
     * @param complement the complement to set
     */
    public void setComplement(String complement) {
        this.complement = complement;
    }

    /**
     * @return the neighbourhood
     */
    public String getNeighbourhood() {
        return neighbourhood;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @return the zipcode
     */
    public String getZipcode() {
        return zipcode;
    }

    /**
     * @return the latitude
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    /**
     * @return the longitude
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * @param longitude the longitude to set
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

}