package com.jumbo.storeLocator.controller;

import com.google.gson.Gson;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.DistanceMatrix;
import com.jumbo.storeLocator.config.ApplicationProperties;
import com.jumbo.storeLocator.domain.Stores;
import com.jumbo.storeLocator.domain.UserLocationDTO;
import com.jumbo.storeLocator.service.IGoogleMapsService;
import com.jumbo.storeLocator.service.IStoreLocationService;
import com.jumbo.storeLocator.service.Implementation.GoogleMapsService;
import com.jumbo.storeLocator.service.Implementation.StoreLocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;


@RestController
public class StoreLocationController {

    private static final Logger logger = LoggerFactory.getLogger(StoreLocationController.class);

    @Autowired
    IStoreLocationService iStoreLocationService;

    @Autowired
    IGoogleMapsService googleMapsService;

    @Autowired
    ApplicationProperties applicationProperties;



    @GetMapping("/storeLocator/{latitude}/{longitude}")
    @CrossOrigin(origins = "http://localhost:4200") //TODO: handle cors in a bean
    public ResponseEntity getUserCurrentLocation(@PathVariable(name = "latitude") String latitude, @PathVariable(name = "longitude") String longitude){
            //System.out.println("Received on server side => " + latitude + " -- " + longitude);
            logger.info("Received on server side => " + latitude + " -- " + longitude);
            UserLocationDTO userLocationDTO = new UserLocationDTO();
            userLocationDTO.setLatitude(new BigDecimal(latitude));
            userLocationDTO.setLongitude(new BigDecimal(longitude));
        //System.out.println("Received on server side => " + userLocationDTO.getLatitude() + " -- " + userLocationDTO.getLongitude());

        List<Stores> nearbyStoresLocation = iStoreLocationService.getNearbyStoresLocation(userLocationDTO);


        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(nearbyStoresLocation);
    }


    @GetMapping("/storeLocator/gApi/{latitude}/{longitude}")
    @CrossOrigin(origins = "http://localhost:4200") //TODO: handle cors in a bean
    public ResponseEntity getStoreDistance(@PathVariable(name = "latitude") String latitude, @PathVariable(name = "longitude") String longitude) throws InterruptedException, ApiException, IOException {
        logger.info("Received on server side => " + latitude + " -- " + longitude);
        System.out.println("Received on server Distance Matrix side => " + latitude + " -- " + longitude);
        UserLocationDTO userLocationDTO = new UserLocationDTO();
        userLocationDTO.setLatitude(new BigDecimal(latitude));
        userLocationDTO.setLongitude(new BigDecimal(longitude));


        DistanceMatrix distanceMatrix = googleMapsService.runApiCall();


        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(distanceMatrix);
    }

    //@GetMapping("/storeLocator/gApiDirection/{originLat}/{originLong}/{destinationLat}/{destinationLong}")
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/storeLocator/gApiDirection/{originLat}/{originLong}/{destinationLat}/{destinationLong}",
            produces = "text/javascript; charset=UTF-8"
    )
    @CrossOrigin(origins = "http://localhost:4200") //TODO: handle cors in a bean
    public ResponseEntity getStoreDirection(@PathVariable(name = "originLat") String originLatitude, @PathVariable(name = "originLong") String originLongitude, @PathVariable(name = "destinationLat") String destinationLatitude, @PathVariable(name = "destinationLong") String destinationLongitude) throws InterruptedException, ApiException, IOException {
        logger.info("Get Store Direction Method");
        String origin = originLatitude + "," + originLongitude;
        String destination = destinationLatitude + "," + destinationLongitude;
        DirectionsResult directionsApi = googleMapsService.getDirectionFromPoint2Point(origin, destination);
        Gson gson = new Gson();
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(gson.toJson(directionsApi));
    }
}
