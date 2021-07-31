package com.jumbo.storeLocator.controller;


import com.jumbo.storeLocator.component.DistanceCalculator;
import com.jumbo.storeLocator.config.ApplicationProperties;
import com.jumbo.storeLocator.domain.Stores;
import com.jumbo.storeLocator.domain.UserLocationDTO;
import com.jumbo.storeLocator.repository.StoreLocationRepository;
import com.jumbo.storeLocator.service.Implementation.StoreLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class StoreLocationController {

    @Autowired
    StoreLocationService storeLocationService;

    @Autowired
    ApplicationProperties applicationProperties;



    @GetMapping("/storeLocator/{latitude}/{longitude}")
    @CrossOrigin(origins = "http://localhost:4200") //TODO: handle cors in a bean
    public ResponseEntity getUserCurrentLocation(@PathVariable(name = "latitude") String latitude, @PathVariable(name = "longitude") String longitude){
            System.out.println("Received on server side => " + latitude + " -- " + longitude);
            UserLocationDTO userLocationDTO = new UserLocationDTO();
            userLocationDTO.setLatitude(new BigDecimal(latitude));
            userLocationDTO.setLongitude(new BigDecimal(longitude));
        System.out.println("Received on server side => " + userLocationDTO.getLatitude() + " -- " + userLocationDTO.getLongitude());

        List<Stores> nearbyStoresLocation = storeLocationService.getNearbyStoresLocation(userLocationDTO);


        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(nearbyStoresLocation);
    }
}
