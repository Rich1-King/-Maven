package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class Cloudservice1Application {

	public static void main(String[] args) {
		SpringApplication.run(Cloudservice1Application.class, args);
	}

	@RequestMapping(value="cloud", method = RequestMethod.GET)
	public String testCloud(){
		return "成功调用cloud";
	}

	@RequestMapping(value="enum", method = RequestMethod.GET)
	public String testEnum(@RequestParam(required = false) Food food){
		System.out.println(food);
		return food.name();
	}

	@RequestMapping(value="obj", method = RequestMethod.POST)
	public Map testObj(@RequestBody Person person){
		System.out.println("obj");
		Map map = new HashMap<>();
		map.put("success", true);
		map.put("data", person);
		return map;
	}

	@RequestMapping(value="class", method = RequestMethod.POST)
	public Person testClass(@RequestBody Person person){
		System.out.println(person.getName()+person.getAge());
		return person;
	}


}
