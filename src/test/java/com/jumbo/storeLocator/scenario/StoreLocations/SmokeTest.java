package com.jumbo.storeLocator.scenario.StoreLocations;

import com.jumbo.storeLocator.controller.StoreLocationController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SmokeTest {

    @Autowired
    private StoreLocationController storeLocationController;

    @Test
    public void contextLoads() throws Exception {
        assertThat(storeLocationController).isNotNull();

    }
}
