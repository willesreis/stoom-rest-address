package com.example.stoom.repository;

import com.example.stoom.entity.Address;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * AddressRepository
 */
@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {

}