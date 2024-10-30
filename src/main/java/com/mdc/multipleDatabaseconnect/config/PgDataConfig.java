package com.mdc.multipleDatabaseconnect.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
@Configuration
public class PgDataConfig {

    @ConfigurationProperties("spring.datasource.pg")
    @Bean
    public DataSourceProperties pgDatasourceProperties(){
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    DataSource pgDataSource(){
        return pgDatasourceProperties().initializeDataSourceBuilder().build();
    }
}
