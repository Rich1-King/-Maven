package com.boot;

import com.boot.config.DataConfig;
import com.boot.config.MailConfig;
import com.boot.config.PersonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
public class SpringbootdemoApplication {

	@Value("${spring.name}")
	String name;

	@Value("${mail}")
	String mail;//因为application.properties是默认的所以可以直接注入

	public static void main(String[] args) {
		SpringApplication.run(SpringbootdemoApplication.class, args);
	}
	@Autowired
	MailConfig mailConfig;

	@Autowired
	PersonConfig personConfig;

	@Autowired
	DataConfig dataConfig;

	@RequestMapping("/value")
	public Map getValue(){
		Map map = new HashMap<String,Object>();

		map.put("name", name);
		map.put("mailCount", mailConfig.mailcount);
		map.put("mail",mail);
		map.put("person",personConfig.getProperty("person"));
		map.put("data", dataConfig.getDataModel());
		return map;
	}

}
