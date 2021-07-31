package com.jumbo.storeLocator.repository;

import com.jumbo.storeLocator.domain.Stores;
import com.jumbo.storeLocator.types.StoreResponse;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StoreRowMapper implements RowMapper<Stores> {


    @Override
    public Stores mapRow(ResultSet rs, int rowNum) throws SQLException {
        Stores stores = new Stores();
        stores.setCity(rs.getString("city"));
        stores.setAddressName(rs.getString("addressname"));
        stores.setLatitude(rs.getBigDecimal("latitude"));
        stores.setLongitude(rs.getBigDecimal("longitude"));
        return stores;
    }
}
