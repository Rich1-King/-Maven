package com.elValue.config;

import com.elValue.service.FruitOtherService;
import com.elValue.service.FruitService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by rich1 on 7/18/16.
 */
@Configuration
@ComponentScan("com.elValue")
public class Config{

    @Bean(initMethod = "init", destroyMethod = "destroy")
    @Profile("one")
    public FruitService getFruitService()
    {
        System.out.println("hello");
        return new FruitService();
    }
    @Bean
    @Profile("two")
    public FruitOtherService getFruitOtherService(){
        return new FruitOtherService();
    }

}
