package com.example.stoom.integration;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PreDestroy;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.Geometry;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * GeocodeContext
 */
@Component
public class GeocodeContext {

    private GeoApiContext context;

    public GeocodeContext() {
        context = new GeoApiContext.Builder().apiKey("AIzaSyBm3xh9oZP1ksMWcMzVaZQevWlrtb8tIgc").build();
    }

    public Map<String, Double> getGeocodeAddress(String address) {
        Map<String, Double> location = new HashMap<>();
        try {
            GeocodingResult[] results = GeocodingApi.geocode(context, address).await();
            if (results.length > 0) {
                Geometry geometry = results[0].geometry;
                location.put("lat", geometry.location.lat);
                location.put("lng", geometry.location.lng);
            }
        } catch (ApiException | InterruptedException | IOException e) {
            LoggerFactory.getLogger(GeocodeContext.class).error(e.getMessage());
        }
        return location;
    }

    @PreDestroy
    protected void destroy() {
        context.shutdown();
    }

}
