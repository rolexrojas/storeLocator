package com.jumbo.storeLocator.service;

import com.jumbo.storeLocator.domain.Stores;
import com.jumbo.storeLocator.domain.UserLocationDTO;

import java.util.List;

public interface IStoreLocationService {
    List<Stores> getNearbyStoresLocation(UserLocationDTO userLocationDTO);
}
