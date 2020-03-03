package com.example.stoom.service.impl;

import com.example.stoom.entity.Address;
import com.example.stoom.integration.GeocodeContext;
import com.example.stoom.repository.AddressRepository;
import com.example.stoom.service.AddressService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * AddressServiceImplTest
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class AddressServiceImplTest {

    @TestConfiguration
    static class AddressServiceImplTestContextConfiguration {

        @Bean
        public AddressService addressService() {
            return new AddressServiceImpl();
        }
    }

    @Autowired
    private AddressService service;

    @MockBean
    private AddressRepository repository;

    @MockBean
    private GeocodeContext context;

    @Test
    public void when_saved_address_it_should_return_address() {
        Address address = newAddress(1L);

        when(repository.save(any(Address.class))).thenReturn(address);

        Address addressCreated = service.save(address);

        assertEquals(addressCreated.getId(), address.getId());
        assertEquals(addressCreated.getStreetName(), address.getStreetName());
    }


    @Test
    public void when_find_by_id_it_should_return_recently_created() {
        Address address = newAddress(1000L);

        when(repository.findById(any(Long.class))).thenReturn(Optional.of(address));

        Optional<Address> addressFound = service.findById(1000L);

        assertTrue(addressFound.isPresent());
        assertEquals(1000L, addressFound.get().getId().longValue());
    }

    @Test
    public void should_return_same_quantity_created() {
        List<Address> list = new ArrayList<>();
        list.add(newAddress(1L));
        list.add(newAddress(2L));
        list.add(newAddress(3L));

        when(repository.findAll()).thenReturn(list);

        List<Address> listFound = new ArrayList<>();
        service.findAll().forEach(a -> listFound.add(a));

        assertEquals(list.size(), listFound.size());
    }

    private Address newAddress(Long id) {
        return new Address(id, "Rua Um", 123, "Bairro Dois", "Três", "Quatro", "Cinco", "12345-000");
    }

}