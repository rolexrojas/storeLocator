package com.jumbo.storeLocator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class StoreLocatorApplication{

	public static void main(String[] args) {
		SpringApplication.run(StoreLocatorApplication.class, args);
	}

}
