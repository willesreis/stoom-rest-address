package com.example.stoom.service;

import java.util.Optional;

import com.example.stoom.entity.Address;

/**
 * AddressService
 */
public interface AddressService {

    public Address save(Address entity);

    public Optional<Address> findById(Long id);

    public Iterable<Address> findAll();

    public void delete(Long id);

}