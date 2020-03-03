package com.example.stoom.controller;

import com.example.stoom.StoomRestAddressApplication;
import com.example.stoom.resource.request.AddressRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = StoomRestAddressApplication.class)
@AutoConfigureMockMvc
public class AddressResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void should_delete_address_after_created() throws Exception {
        AddressRequest request = new AddressRequest();
        request.setStreetName("Rua Um");
        request.setNumber(123);
        request.setNeighbourhood("Bairro Dois");
        request.setCity("Três");
        request.setState("Quatro");
        request.setCountry("Cinco");
        request.setZipcode("12345-000");
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(request);
        MvcResult resultPost = mockMvc.perform(MockMvcRequestBuilders.post("/address/post")
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(content)).andReturn();
        assertEquals(200, resultPost.getResponse().getStatus());

        MvcResult resultDelete = mockMvc.perform(MockMvcRequestBuilders.delete("/address/delete/{addressId}", 1L)).andReturn();
        assertEquals(200, resultDelete.getResponse().getStatus());
    }

}
