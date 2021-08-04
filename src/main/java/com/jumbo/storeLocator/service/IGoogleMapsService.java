package com.jumbo.storeLocator.service;

import com.google.maps.errors.ApiException;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.DistanceMatrix;

import java.io.IOException;

public interface IGoogleMapsService {
    DistanceMatrix runApiCall() throws InterruptedException, ApiException, IOException;
    DirectionsResult getDirectionFromPoint2Point(String origin, String destination) throws InterruptedException, ApiException, IOException;
}
