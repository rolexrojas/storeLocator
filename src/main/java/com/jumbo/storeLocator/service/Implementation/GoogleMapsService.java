package com.jumbo.storeLocator.service.Implementation;

import com.google.maps.DirectionsApi;
import com.google.maps.DistanceMatrixApi;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.TravelMode;
import com.google.maps.model.Unit;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

//HERE I WILL COME THE JAVA CLIENT API FOR GOOGLE MAP TO GET INFORMATION OF TOP FIVE CLOSEST ROUTES
@Service
public class GoogleMapsService {

    public DistanceMatrix runApiCall() throws InterruptedException, ApiException, IOException {

        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("AIzaSyBin4uVSYE8jpHGHrmfi_inTDGA_OiUhAA")
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

    public DirectionsResult getDirectionFromPoint2Point(String origin, String destination) throws InterruptedException, ApiException, IOException {
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("AIzaSyBin4uVSYE8jpHGHrmfi_inTDGA_OiUhAA")
                .build();

        DirectionsResult result =
                DirectionsApi.getDirections(context, origin, destination)
                        .mode(TravelMode.DRIVING)
                        .language("en-EN")
                        .avoid(DirectionsApi.RouteRestriction.TOLLS)
                        .units(Unit.IMPERIAL)
                        .await();

        context.shutdown();
        return result;
    }

}


//origins=41.43206,-81.38992|-33.86748,151.20699

//https://maps.googleapis.com/maps/api/distancematrix/json?units=imperial&origins=40.6655101,-73.89188969999998&destinations=40.6905615%2C-73.9976592%7C40.6905615%2C-73.9976592%7C40.6905615%2C-73.9976592%7C40.6905615%2C-73.9976592%7C40.6905615%2C-73.9976592%7C40.6905615%2C-73.9976592%7C40.659569%2C-73.933783%7C40.729029%2C-73.851524%7C40.6860072%2C-73.6334271%7C40.598566%2C-73.7527626%7C40.659569%2C-73.933783%7C40.729029%2C-73.851524%7C40.6860072%2C-73.6334271%7C40.598566%2C-73.7527626&key=YOUR_API_KEY

//added feature: can use several modes after completion with driving as default