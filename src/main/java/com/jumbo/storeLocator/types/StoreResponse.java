package com.jumbo.storeLocator.types;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.math.BigDecimal;

public class StoreResponse implements Serializable {

    @JsonProperty("city")
    private String city; //:"Aalst",

    @JsonProperty("longitude")
    private BigDecimal longitude; //:"5.469597",

    @JsonProperty("latitude")
    private BigDecimal latitude; //:"51.399843",

    @JsonProperty("addressName")
    private String addressName; //:"Jumbo Aalst Paul en Marjon Houben",

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }
}
