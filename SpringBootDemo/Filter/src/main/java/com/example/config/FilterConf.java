package com.example.config;

import com.example.filter.MyFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

/**
 * 用配置文件添加过滤器
 * Created by rich1 on 9/16/16.
 */
@Configuration
public class FilterConf {

    /**
     * 添加过滤器
     * @return
     */
    /**
    @Bean
    public FilterRegistrationBean myFilterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setName("myFilter");
        MyFilter myFilter = new MyFilter();
        registrationBean.setFilter(myFilter);
        registrationBean.setOrder(1);
        List<String> urlList = new ArrayList<String>();
        urlList.add("/*");
        registrationBean.setUrlPatterns(urlList);
        System.out.println("config");
        return registrationBean;
    }**/


    /**
     * 添加过滤器
     */
    @Bean
    public Filter setFilter(){
        System.out.println("myfilter");
        return new MyFilter();
    }
}
