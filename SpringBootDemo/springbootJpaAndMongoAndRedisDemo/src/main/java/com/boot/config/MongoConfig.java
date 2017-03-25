package com.boot.config;

import com.mongodb.Mongo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * Created by rich1 on 9/27/16.
 */
@Configuration
public class MongoConfig{

    @Value("${mongodb.host}")
    public String mongoUrl;

    @Value("${mongodb.port}")
    public int mongoPort;

    @Bean
    public MongoTemplate mongoTemplate(){
        System.out.println("开始连接mongo:");
        return new MongoTemplate(new Mongo(mongoUrl, mongoPort),"test");
    }
}
