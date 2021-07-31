package com.jumbo.storeLocator.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Attributes {
    @JsonIgnore
    private String longitude;
    @JsonIgnore
    private String latitude;

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
