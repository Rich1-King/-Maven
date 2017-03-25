package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Logge4jdemoApplication {

	private static Logger logger = Logger.getLogger(Logge4jdemoApplication
			.class);

	public static void main(String[] args) {
		SpringApplication.run(Logge4jdemoApplication.class, args);
		logger.info("hello");
	}
}
