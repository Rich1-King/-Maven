package com.manyThread.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by rich1 on 7/18/16.
 */
@Configuration
@ComponentScan("com.manyThread")
@EnableScheduling
public class ScheduledTaskConfig{
}
