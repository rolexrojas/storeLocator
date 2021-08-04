package com.jumbo.storeLocator.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApplicationProperties {

    @Value("${spring.datasource.url}")
    private String dataSourceUrl;
    @Value("${spring.datasource.username}")
    private String dataSourceUsername;
    @Value("${spring.jpa.database-platform}")
    private String databasePlatform;
    @Value("${spring.datasource.password}")
    private String dataSourcePassword;
    @Value("${spring.datasource.DriverClassName}")
    private String datasourceDriverClassName;
    @Value("${server.port}")
    private String serverPort;
    @Value("${maps_api_key}")
    private String mapsApiKey;
    @Value("${store.location.limit.count}")
    private String storeLocationLimitCount;
    @Value("${maps.api.direction.language}")
    private String mapsApiDirectionLanguage;

    public String getDataSourceUrl() {
        return dataSourceUrl;
    }

    public void setDataSourceUrl(String dataSourceUrl) {
        this.dataSourceUrl = dataSourceUrl;
    }

    public String getDataSourceUsername() {
        return dataSourceUsername;
    }

    public void setDataSourceUsername(String dataSourceUsername) {
        this.dataSourceUsername = dataSourceUsername;
    }

    public String getDatabasePlatform() {
        return databasePlatform;
    }

    public void setDatabasePlatform(String databasePlatform) {
        this.databasePlatform = databasePlatform;
    }

    public String getDataSourcePassword() {
        return dataSourcePassword;
    }

    public void setDataSourcePassword(String dataSourcePassword) {
        this.dataSourcePassword = dataSourcePassword;
    }

    public String getDatasourceDriverClassName() {
        return datasourceDriverClassName;
    }

    public void setDatasourceDriverClassName(String datasourceDriverClassName) {
        this.datasourceDriverClassName = datasourceDriverClassName;
    }

    public String getServerPort() {
        return serverPort;
    }

    public void setServerPort(String serverPort) {
        this.serverPort = serverPort;
    }

    public String getMapsApiKey() {
        return mapsApiKey;
    }

    public void setMapsApiKey(String mapsApiKey) {
        this.mapsApiKey = mapsApiKey;
    }

    public String getStoreLocationLimitCount() {
        return storeLocationLimitCount;
    }

    public void setStoreLocationLimitCount(String storeLocationLimitCount) {
        this.storeLocationLimitCount = storeLocationLimitCount;
    }

    public String getMapsApiDirectionLanguage() {
        return mapsApiDirectionLanguage;
    }

    public void setMapsApiDirectionLanguage(String mapsApiDirectionLanguage) {
        this.mapsApiDirectionLanguage = mapsApiDirectionLanguage;
    }
}

