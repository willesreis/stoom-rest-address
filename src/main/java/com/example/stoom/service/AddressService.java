package com.example.stoom.service;

import java.util.Map;
import java.util.Optional;

import com.example.stoom.entity.Address;
import com.example.stoom.integration.GeocodeContext;
import com.example.stoom.repository.AddressRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * AddressService
 */
@Service
public class AddressService {

    @Autowired
    private AddressRepository repository;

    @Autowired
    private GeocodeContext context;

    public void save(Address entity) {
        prepareGeocoding(entity);
        repository.save(entity);
    }

    public Optional<Address> findById(Long id) {
        return repository.findById(id);
    }

    public Iterable<Address> findAll() {
        return repository.findAll();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private void prepareGeocoding(Address entity) {
        if (null == entity.getLatitude() || null == entity.getLongitude() || entity.getLatitude().isEmpty()
                || entity.getLongitude().isEmpty()) {
            Map<String, Double> location = context.getGeocodeAddress(String.format("%s, %d, %s, %s, %s, %s, %s",
                    entity.getStreetName(), entity.getNumber(), entity.getNeighbourhood(), entity.getCity(),
                    entity.getState(), entity.getCountry(), entity.getZipcode()));
            String latitude = location.isEmpty() ? null : location.get("lat").toString();
            String longitude = location.isEmpty() ? null : location.get("lng").toString();
            entity.setLatitude(latitude);
            entity.setLongitude(longitude);
        }
    }

}