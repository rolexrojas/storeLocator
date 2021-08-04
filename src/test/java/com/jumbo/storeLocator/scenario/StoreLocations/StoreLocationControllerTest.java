package com.jumbo.storeLocator.scenario.StoreLocations;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jumbo.storeLocator.config.ApplicationProperties;
import com.jumbo.storeLocator.controller.StoreLocationController;
import com.jumbo.storeLocator.domain.Stores;
import com.jumbo.storeLocator.domain.UserLocationDTO;
import com.jumbo.storeLocator.service.IGoogleMapsService;
import com.jumbo.storeLocator.service.IStoreLocationService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StoreLocationController.class)
@ActiveProfiles("test")
public class StoreLocationControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    IGoogleMapsService googleMapsService;

    @MockBean
    ApplicationProperties applicationProperties;

    @Autowired
    ObjectMapper mapper;

    @MockBean
    IStoreLocationService iStoreLocationService;


    private BigDecimal testLatitud = new BigDecimal(51.3063826);
    private BigDecimal testLongitud = new BigDecimal(4.921009);
    private String latitude = "51.3063826";
    private String longitude = "4.921009";
    Stores STORE_1 = new Stores("Barle-Nassau", null, null,null, null, "Jumbo Baarle-Nassau Bresser St. Annaplein","", new BigDecimal(4.93209),new BigDecimal(51.444124),0, false, null, null, false, 0, null);
    Stores STORE_2 = new Stores("Reusel", null, null,null, null, "Jumbo Reusel Markt","", new BigDecimal(5.16139),new BigDecimal(51.3625),0, false, null, null, false, 0, null);
    Stores STORE_3 = new Stores("Bladel", null, null,null, null, "Jumbo Bladel Gindrapassage","", new BigDecimal(5.218227),new BigDecimal(51.366486),0, false, null, null, false, 0, null);
    Stores STORE_4 = new Stores("Hapert", null, null,null, null, "Jumbo Hapert Markt","", new BigDecimal(5.251834),new BigDecimal(51.369247),0, false, null, null, false, 0, null);
    Stores STORE_5 = new Stores("Hilvarenbeek", null, null,null, null, "Jumbo Hilvarenbeek Hilverstraat","", new BigDecimal(5.138948),new BigDecimal(51.483345),0, false, null, null, false, 0, null);


    @Test
    public void getConfiguredStores_success() throws Exception {
        List<Stores> stores = new ArrayList<>();
        stores.add(STORE_1);
        stores.add(STORE_2);
        UserLocationDTO userLocationDTO = new UserLocationDTO();
        userLocationDTO.setLongitude(testLongitud);
        userLocationDTO.setLatitude(testLatitud);
        Mockito.when(iStoreLocationService.getNearbyStoresLocation(userLocationDTO)).thenReturn(stores);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/storeLocator/51.3063826/4.921009")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)))
                .andExpect(jsonPath("$", notNullValue()));


    }

}
