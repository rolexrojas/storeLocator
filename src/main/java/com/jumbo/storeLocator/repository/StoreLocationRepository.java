package com.jumbo.storeLocator.repository;

import com.jumbo.storeLocator.domain.StoreLocation;
import com.jumbo.storeLocator.domain.Stores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Repository
public class StoreLocationRepository {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private String query = "SELECT latitude, longitude, city, addressname, SQRT(" +
            " POWER(69.1 * (latitude - :start_latitude), 2) + " +
            " POWER(69.1 * (:start_longitude - longitude) * COS(latitude / 57.3), 2)) AS distance" +
            " FROM store_location ORDER BY distance LIMIT 5";


    //TODO: ADD CONFIG FOR LIMIT COUNT
    /**
      SELECT latitude, longitude, SQRT(
          POW(69.1 * (latitude - [startlat]), 2) +
          POW(69.1 * ([startlng] - longitude) * COS(latitude / 57.3), 2)) AS distance
     FROM TableName HAVING distance < 25 ORDER BY distance;
      //HAVING distance < 25 ORDER BY distance;

      select * from store_location

     * */

    public List<Stores> getTopFiveNearStore(BigDecimal lat, BigDecimal lon){
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("start_latitude", lat).addValue("start_longitude", lon);
        return this.namedParameterJdbcTemplate.query(query, namedParameters, new StoreRowMapper());
        //this.jdbcTemplate.queryForObject(query, namedParameters.g, new StoreRowMapper());


    }


}