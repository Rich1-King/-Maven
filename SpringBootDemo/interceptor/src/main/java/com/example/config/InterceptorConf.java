package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by rich1 on 9/16/16.
 */
@Configuration
public class InterceptorConf extends WebMvcConfigurerAdapter{

    /**
     * 注册自定义拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        //为拦截器指定过滤路径
        registry.addInterceptor(new Interceptor1()).addPathPatterns("/**");

        super.addInterceptors(registry);
    }
}
