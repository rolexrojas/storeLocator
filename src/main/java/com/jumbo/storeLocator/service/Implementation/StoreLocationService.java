package com.jumbo.storeLocator.service.Implementation;

import com.jumbo.storeLocator.config.ApplicationProperties;
import com.jumbo.storeLocator.domain.Stores;
import com.jumbo.storeLocator.domain.UserLocationDTO;
import com.jumbo.storeLocator.repository.StoreLocationRepository;
import com.jumbo.storeLocator.service.IStoreLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreLocationService implements IStoreLocationService {

    @Autowired
    StoreLocationRepository storeLocationRepository;


    @Override
    public List<Stores> getNearbyStoresLocation(UserLocationDTO userLocationDTO) {
        return storeLocationRepository.getTopFiveNearStore(userLocationDTO.getLatitude(), userLocationDTO.getLongitude());
    }
}
