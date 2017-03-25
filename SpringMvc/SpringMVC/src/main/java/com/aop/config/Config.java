package com.aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by rich1 on 7/18/16.
 */
@Configuration
@ComponentScan("com.aop")
@EnableAspectJAutoProxy
public class Config{
}
