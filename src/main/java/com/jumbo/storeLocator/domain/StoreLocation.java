package com.jumbo.storeLocator.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class StoreLocation {
    private List<Stores> stores;

    private Attributes attributes;

    public List<Stores> getStores() {
        return stores;
    }

    public void setStores(List<Stores> stores) {
        this.stores = stores;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }
}
