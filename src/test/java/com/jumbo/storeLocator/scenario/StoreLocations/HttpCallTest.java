package com.jumbo.storeLocator.scenario.StoreLocations;

import com.jumbo.storeLocator.domain.Stores;
import com.jumbo.storeLocator.types.StoreResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;


import java.math.BigDecimal;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpCallTest {

    //@Autowired
    //private MockMvc mockMvc;




    @Test
    public void storeLocationsShouldReturnFiveElements() throws Exception {

        //ResponseEntity<Stores> forEntity = this.restTemplate.getForEntity("http://localhost:" + port + "/storeLocator/66.152525/11.1545225", Stores.class).contentType(MediaType.APPLICATION_JSON);

    }
}
