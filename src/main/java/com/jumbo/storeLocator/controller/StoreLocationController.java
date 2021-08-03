package com.jumbo.storeLocator.controller;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.services.mapsengine.model.Feature;
import com.google.api.services.mapsengine.model.FeaturesListResponse;
import com.google.gson.Gson;
import com.google.maps.DirectionsApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.DistanceMatrix;
import com.jumbo.storeLocator.component.DistanceCalculator;
import com.jumbo.storeLocator.config.ApplicationProperties;
import com.jumbo.storeLocator.domain.Stores;
import com.jumbo.storeLocator.domain.UserLocationDTO;
import com.jumbo.storeLocator.repository.StoreLocationRepository;
import com.jumbo.storeLocator.service.Implementation.GoogleMapsService;
import com.jumbo.storeLocator.service.Implementation.StoreLocationService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
public class StoreLocationController {

    @Autowired
    StoreLocationService storeLocationService;

    @Autowired
    GoogleMapsService googleMapsService;

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


    @GetMapping("/storeLocator/gApi/{latitude}/{longitude}")
    @CrossOrigin(origins = "http://localhost:4200") //TODO: handle cors in a bean
    public ResponseEntity getStoreDistance(@PathVariable(name = "latitude") String latitude, @PathVariable(name = "longitude") String longitude) throws InterruptedException, ApiException, IOException {
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
    public ResponseEntity getStoreDirection(@PathVariable(name = "originLat") String originLatitude, @PathVariable(name = "originLong") String originLongitude, @PathVariable(name = "destinationLat") String destinationLatitude, @PathVariable(name = "destinationLong") String destinationLongitude) throws InterruptedException, ApiException, IOException, InvocationTargetException, IllegalAccessException, JSONException {
        //System.out.println("Received on server Distance Matrix side => " + latitude + " -- " + longitude);
       /*UserLocationDTO userLocationDTO = new UserLocationDTO();
        userLocationDTO.setLatitude(new BigDecimal(latitude));
        userLocationDTO.setLongitude(new BigDecimal(longitude));
        sample request in hometown
        http://localhost:8582/storeLocator/gApiDirection/19.306231699999998/-69.5458131/19.306414/-69.5472377
        */
        Gson gson = new Gson();
       String origin = originLatitude + "," + originLongitude;
       String destination = destinationLatitude + "," + destinationLongitude;
        DirectionsResult directionsApi = googleMapsService.getDirectionFromPoint2Point(origin, destination);
        //String temp = gson.toJson(directionsApi);
        ObjectMapper mapper = new ObjectMapper();



       // for(int x = 0; x < directionsApi.routes[0].legs[0].steps.length; x++){

           // gson.
        //directionsApi.routes[0].legs[0].steps[x].htmlInstructions = "";
      // }
        //directionsApi.routes[0].legs[0].steps = null;


      // com.jumbo.storeLocator.types.google.dto.model.DirectionsResult directionResponse = gson.fromJson(temp, com.jumbo.storeLocator.types.google.dto.model.DirectionsResult.class);
        //DirectionsResult directionsResult = gson.fromJson(String.valueOf(directionsApi), DirectionsResult.class);
        gson.newBuilder().setPrettyPrinting().create();
        System.out.println("[plain direction api object ] => " + directionsApi);
        System.out.println("[gson.toJson direction api object ] => " + gson.toJson(directionsApi));
        System.out.println("[jackson as String direction api object ] => " + mapper.writeValueAsString(directionsApi));
       // System.out.println("[plan direction api object ] => " + gson..setPrettyPrinting().directionsApi);
      //  System.out.println("[plan direction api object ] => " + directionsApi);
       // System.out.println("[2ble parsed api object ] => " + parsedResult);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(gson.toJson(directionsApi));
    }
}
