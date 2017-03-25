package com.rich1.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * Created by sunchong on 2016/12/8.
 */
@Configuration
public class DatasourceConfig{

    @Bean(name = "db1DataSource")
    @Qualifier("db1DataSource")
    @Primary//必须配一个
    @ConfigurationProperties(prefix="spring.datasource.db1")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "db2DataSource")
    @Qualifier("db2DataSource")
    @ConfigurationProperties(prefix="spring.datasource.db2")
    public DataSource secondaryDataSource() {
        return DataSourceBuilder.create().build();
    }

}
