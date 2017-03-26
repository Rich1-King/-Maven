package com.boot.config;

/**
 * Created by sunchong on 2017/2/20.
 */

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Configuration
public class AppConfig{

    public static String ENVIROMENT;

    static Properties properties = new Properties();
    static Logger logger = Logger.getLogger(AppConfig.class);
    static{
        try{
            loadConfig();
        }catch (IOException e){
            logger.error("application.properties配置文件读取失败");
        }
    }

    public static void loadConfig() throws IOException{
        InputStream inputStream = AppConfig.class.getResourceAsStream("/application.properties");
        properties.load(inputStream);
        ENVIROMENT = properties.getProperty("spring.profiles.active");
    }

}
