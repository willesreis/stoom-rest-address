package com.example.stoom.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.example.stoom.entity.Address;
import com.example.stoom.resource.request.AddressRequest;
import com.example.stoom.resource.response.AddressResponse;
import com.example.stoom.service.AddressService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AddressResource
 */
@RestController
@RequestMapping(value = "/address")
public class AddressResource {

    @Autowired
    private AddressService service;

    @PostMapping(value = "/post")
    public void postAddress(@Valid @RequestBody AddressRequest request) {
        service.save(request.toEntity(null));
    }

    @GetMapping(value = "/get")
    public List<AddressResponse> getAllAddress() {
        List<AddressResponse> response = new ArrayList<>();
        service.findAll().forEach(a -> response.add(new AddressResponse(a)));
        return response;
    }

    @GetMapping(value = "/get/{addressId}")
    public AddressResponse getAddressById(@PathVariable Long addressId) {
        Optional<Address> address = service.findById(addressId);
        if (address.isPresent()) {
            return new AddressResponse(address.get());
        }
        return null;
    }

    @PutMapping(value = "/put/{addressId}")
    public void putAddress(@PathVariable Long addressId, @RequestBody AddressRequest request) {
        service.save(request.toEntity(addressId));
    }

    @DeleteMapping(value = "/delete/{addressId}")
    public void deleteAddress(@PathVariable Long addressId) {
        service.delete(addressId);
    }

}