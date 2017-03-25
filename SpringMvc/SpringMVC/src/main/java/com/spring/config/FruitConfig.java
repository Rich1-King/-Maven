package com.spring.config;

import com.spring.bean.Fruit;
import com.spring.service.FruitService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by rich1 on 7/18/16.
 */
@Configuration
@ComponentScan("com.spring")
public class FruitConfig{

    @Bean
    public Fruit getFruit()
    {
        return new Fruit();
    }
    @Bean
    public FruitService getFruitService()
    {
        FruitService fruitService = new FruitService();
        fruitService.setFruit(getFruit());
        return fruitService;
    }


}
