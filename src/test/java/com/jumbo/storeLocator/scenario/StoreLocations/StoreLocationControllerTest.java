package com.jumbo.storeLocator.scenario.StoreLocations;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.maps.model.AddressType;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.GeocodedWaypoint;
import com.google.maps.model.GeocodedWaypointStatus;
import com.jumbo.storeLocator.config.ApplicationProperties;
import com.jumbo.storeLocator.config.Database;
import com.jumbo.storeLocator.controller.StoreLocationController;
import com.jumbo.storeLocator.domain.Stores;
import com.jumbo.storeLocator.domain.UserLocationDTO;
import com.jumbo.storeLocator.repository.StoreLocationRepository;
import com.jumbo.storeLocator.service.IGoogleMapsService;
import com.jumbo.storeLocator.service.IStoreLocationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class StoreLocationControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    IGoogleMapsService iGoogleMapsService;

    @Autowired
    IStoreLocationService storeLocationService;
     public BigDecimal testLatitud = new BigDecimal(51.3063826);
     public BigDecimal testLongitud = new BigDecimal(4.921009);
     public String latitude = "51.3063826";
     public String longitude = "4.921009";

    @Test
    public void getConfiguredStores_success() throws Exception {

         BigDecimal testLatitud = new BigDecimal(51.3063826);
         BigDecimal testLongitud = new BigDecimal(4.921009);
         Stores STORE_1 = new Stores("Barle-Nassau", null, null,null, null, "Jumbo Baarle-Nassau Bresser St. Annaplein","", new BigDecimal(4.93209),new BigDecimal(51.444124),0, false, null, null, false, 0, null);
         Stores STORE_2 = new Stores("Reusel", null, null,null, null, "Jumbo Reusel Markt","", new BigDecimal(5.16139),new BigDecimal(51.3625),0, false, null, null, false, 0, null);
         Stores STORE_3 = new Stores("Bladel", null, null,null, null, "Jumbo Bladel Gindrapassage","", new BigDecimal(5.218227),new BigDecimal(51.366486),0, false, null, null, false, 0, null);
         Stores STORE_4 = new Stores("Hapert", null, null,null, null, "Jumbo Hapert Markt","", new BigDecimal(5.251834),new BigDecimal(51.369247),0, false, null, null, false, 0, null);
         Stores STORE_5 = new Stores("Hilvarenbeek", null, null,null, null, "Jumbo Hilvarenbeek Hilverstraat","", new BigDecimal(5.138948),new BigDecimal(51.483345),0, false, null, null, false, 0, null);


        List<Stores> listStores = new LinkedList<>();
        listStores.add(STORE_1);
        listStores.add(STORE_2);
        listStores.add(STORE_3);
        listStores.add(STORE_4);
        listStores.add(STORE_5);
        UserLocationDTO userLocationDTO = new UserLocationDTO();
        userLocationDTO.setLongitude(testLongitud);
        userLocationDTO.setLatitude(testLatitud);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/storeLocator/{latitude}/{longitude}", "51.3063826", "4.921009")
                .contentType(MediaType.APPLICATION_JSON)
                .content(convertToJson(listStores)))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$", hasSize(5)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].latitude", notNullValue()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].longitude", notNullValue()));
    }

    public static MediaType getJsonMediaType() {
        return new MediaType(MediaType.APPLICATION_JSON.getType(),
                MediaType.APPLICATION_JSON.getSubtype(),
                Charset.forName("utf8"));
    }

    public static String convertToJson(Object o) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(o));
        return  mapper.writeValueAsString(o);
    }

    /*
    @BeforeEach
    public void setUp(){

    }*/

    @Test
    public void getDirectionsApi_success() throws Exception {

        DirectionsResult directionsApi = new DirectionsResult();
        String origin = testLatitud.toString() + "," + testLongitud.toString();
        String destination = 52.3773511 + "," + 4.8944363;
        Mockito.when(iGoogleMapsService.getDirectionFromPoint2Point(origin, destination)).thenReturn(directionsApi);


        mockMvc.perform(MockMvcRequestBuilders
                .get("/storeLocator/gApiDirection/{originLat}/{originLong}/{destinationLat}/{destinationLong}", 51.3063826,4.921009,51.3063826,4.921009)
                .contentType(MediaType.APPLICATION_JSON)
                .content(convertToJson(directionsApi)))
                .andExpect(status().isOk());
    }

}
