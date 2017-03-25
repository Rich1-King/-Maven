package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //该注解中已经包含了扫描Configuration,Bean,Control,Service,
// Repository
//@ServletComponentScan　//该注解会自动扫描servlet中的配置，例如@WebListener,@WebFilter
public class FilterApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilterApplication.class, args);
	}
}
