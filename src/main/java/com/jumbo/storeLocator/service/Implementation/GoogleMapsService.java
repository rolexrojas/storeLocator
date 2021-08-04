package com.jumbo.storeLocator.service.Implementation;

import com.google.maps.DirectionsApi;
import com.google.maps.DistanceMatrixApi;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.TravelMode;
import com.google.maps.model.Unit;
import com.jumbo.storeLocator.config.ApplicationProperties;
import com.jumbo.storeLocator.service.IGoogleMapsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

//HERE I WILL COME THE JAVA CLIENT API FOR GOOGLE MAP TO GET INFORMATION OF TOP FIVE CLOSEST ROUTES
@Service
public class GoogleMapsService implements IGoogleMapsService {

    private static final Logger logger = LoggerFactory.getLogger(GoogleMapsService.class);

    @Autowired
    ApplicationProperties applicationProperties;

    /**
     * This method is no longer in used, was replace by getDirectionFromPoint2Point
     * */
    @Override
    public DistanceMatrix runApiCall() throws InterruptedException, ApiException, IOException {
        logger.info("Entering runApiCall Method");
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey(applicationProperties.getMapsApiKey())
                .build();

        String[] origins =
                new String[]{
                        "Sydney, Australia"
                };
        String[] destinations =
                new String[]{
                        "Uluru, Australia",
                        "Kakadu, Australia",
                        "Blue Mountains, Australia",
                        "Bungle Bungles, Australia",
                        "The Pinnacles, Australia"
                };

        DistanceMatrix response = DistanceMatrixApi.newRequest(context)
                .origins(origins)
                .destinations(destinations)
                .mode(TravelMode.DRIVING)
                .language("en-AU")
                .avoid(DirectionsApi.RouteRestriction.TOLLS)
                .units(Unit.IMPERIAL)
                .departureTime(
                        Instant.now().plus(Duration.ofMinutes(2))) // this is ignored when an API key is used
                .await();

        //System.out.println(response.rows);


        context.shutdown();
        return response;
    }

    /**
    * This method is called once a marker is clicked on the map.
     * It will retrieve all the direction information related to origin
     * and destination
     * */

    @Override
    public DirectionsResult getDirectionFromPoint2Point(String origin, String destination) throws InterruptedException, ApiException, IOException {
        logger.info("Entering getDirectionFromPoint2Point Method");
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey(applicationProperties.getMapsApiKey())
                .build();

        DirectionsResult result =
                DirectionsApi.getDirections(context, origin, destination)
                        .mode(TravelMode.DRIVING)
                        .language(applicationProperties.getMapsApiDirectionLanguage())
                        .avoid(DirectionsApi.RouteRestriction.TOLLS)
                        .units(Unit.IMPERIAL)
                        .await();

        context.shutdown();
        return result;
    }

}