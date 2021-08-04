package com.jumbo.storeLocator.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jumbo.storeLocator.config.ApplicationProperties;
import com.jumbo.storeLocator.domain.StoreLocation;
import com.jumbo.storeLocator.domain.Stores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.io.InputStream;

@Component
public class InitialDataLoader  implements CommandLineRunner {
    @Autowired
    ApplicationProperties applicationProperties;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) throws Exception {
        //create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        //read json file and convert to customer object
        InputStream in = this.getClass().getClassLoader()
                .getResourceAsStream("stores.json");
        try {
            StoreLocation storeLocation = objectMapper.readValue(in, StoreLocation.class);


        //print customer details
        //TODO: Run this from an Isolated Component and Invoke it Start from Spring
        for (Stores store: storeLocation.getStores()) {
            String sqlInsert = "INSERT INTO store_location (city, street, street2, street3, addressName, uuid, latitude, longitude, complexNumber, showWarningMessage, todayOpen, locationType, collectionPoint, sapStoreID, todayClose) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            jdbcTemplate.update(sqlInsert, store.getCity(), store.getStreet(), store.getStreet2(), store.getStreet3(), store.getAddressName(), store.getUuid(), store.getLatitude(), store.getLongitude(), store.getComplexNumber(), store.isShowWarningMessage(), store.getTodayOpen(), store.getLocationType(), store.isCollectionPoint(), store.getSapStoreID(), store.getTodayClose());
        }
        }catch (Exception e){}
    }
}
