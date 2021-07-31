package com.jumbo.storeLocator.domain;

//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Date;

//@Document(collection = "stores")
public class Stores {

    //@Id
    //private String id;
    private String city; //:"Aalst",
    private String postalCode; //:"5582 CL",
    private String street; //:"Hortensialaan",
    private String street2; //:"2",
    private String street3; //:"",
    private String addressName; //:"Jumbo Aalst Paul en Marjon Houben",
    private String uuid; //:"Tk0KYx4XZ3YAAAFc_DRE1DKo",
    private BigDecimal longitude; //:"5.469597",
    private BigDecimal latitude; //:"51.399843",
    private int complexNumber; //:"33011",
    private boolean showWarningMessage; //:true,
    private String todayOpen; //:"08:00",
    private String locationType; //:"SupermarktPuP",
    private boolean collectionPoint; //:true,
    private int sapStoreID; //:"3754",
    private String todayClose; //:"20:00"


    public Stores(){}

    public Stores(String city, String postalCode, String street, String street2, String street3, String addressName, String uuid, BigDecimal longitude, BigDecimal latitude, int complexNumber, boolean showWarningMessage, String todayOpen, String locationType, boolean collectionPoint, int sapStoreID, String todayClose) {
        this.city = city;
        this.postalCode = postalCode;
        this.street = street;
        this.street2 = street2;
        this.street3 = street3;
        this.addressName = addressName;
        this.uuid = uuid;
        this.longitude = longitude;
        this.latitude = latitude;
        this.complexNumber = complexNumber;
        this.showWarningMessage = showWarningMessage;
        this.todayOpen = todayOpen;
        this.locationType = locationType;
        this.collectionPoint = collectionPoint;
        this.sapStoreID = sapStoreID;
        this.todayClose = todayClose;
    }

   // public String getId() {
     //   return id;
   // }

    //public void setId(String id) {
     //   this.id = id;
   // }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getStreet3() {
        return street3;
    }

    public void setStreet3(String street3) {
        this.street3 = street3;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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

    public int getComplexNumber() {
        return complexNumber;
    }

    public void setComplexNumber(int complexNumber) {
        this.complexNumber = complexNumber;
    }

    public boolean isShowWarningMessage() {
        return showWarningMessage;
    }

    public void setShowWarningMessage(boolean showWarningMessage) {
        this.showWarningMessage = showWarningMessage;
    }

    public String getTodayOpen() {
        return todayOpen;
    }

    public void setTodayOpen(String todayOpen) {
        this.todayOpen = todayOpen;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public boolean isCollectionPoint() {
        return collectionPoint;
    }

    public void setCollectionPoint(boolean collectionPoint) {
        this.collectionPoint = collectionPoint;
    }

    public int getSapStoreID() {
        return sapStoreID;
    }

    public void setSapStoreID(int sapStoreID) {
        this.sapStoreID = sapStoreID;
    }

    public String getTodayClose() {
        return todayClose;
    }

    public void setTodayClose(String todayClose) {
        this.todayClose = todayClose;
    }
}