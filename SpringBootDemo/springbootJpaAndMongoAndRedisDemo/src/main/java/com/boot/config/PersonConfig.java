package com.boot.config;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by rich1 on 8/13/16.
 */
@Component
public class PersonConfig{

    private static Properties props = new Properties();

    public PersonConfig(){

        try {
            //方法一
            //Resource resource = new ClassPathResource("/person.properties");//
            //props = PropertiesLoaderUtils.loadProperties(resource);
            //方法二
            InputStream inputStream = PersonConfig.class.getResourceAsStream("/person.properties");
            props.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取属性
     * @param key
     * @return
     */
    public static String getProperty(String key){

        return props == null ? null :  props.getProperty(key);

    }

    /**
     * 获取属性
     * @param key 属性key
     * @param defaultValue 属性value
     * @return
     */
    public static String getProperty(String key,String defaultValue){

        return props == null ? null : props.getProperty(key, defaultValue);

    }

    /**
     * 获取properyies属性
     * @return
     */
    public static Properties getProperties(){
        return props;
    }

}
