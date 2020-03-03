package com.example.stoom.repository;

import com.example.stoom.entity.Address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * AddressRepository
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}