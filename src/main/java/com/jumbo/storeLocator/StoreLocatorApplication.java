package com.jumbo.storeLocator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jumbo.storeLocator.domain.StoreLocation;
import com.jumbo.storeLocator.domain.Stores;
import org.apache.catalina.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;


@SpringBootApplication
public class StoreLocatorApplication{

	public static void main(String[] args) {
		SpringApplication.run(StoreLocatorApplication.class, args);
	}

}
