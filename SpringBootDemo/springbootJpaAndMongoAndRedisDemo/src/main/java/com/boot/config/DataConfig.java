package com.boot.config;

import com.boot.model.vo.DataModel;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by rich1 on 8/13/16.
 */
@Configuration
public class DataConfig{

    @Bean
    @ConfigurationProperties(locations = "classpath:data.properties")
    public DataModel getDataModel(){
       DataModel dataModel = new DataModel();
        return dataModel;

    }
}
