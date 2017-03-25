package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
@EnableFeignClients
@EnableDiscoveryClient
@EnableConfigurationProperties
public class Cloudservice2Application {

//	@Autowired
//	RestTemplate restTemplate;

	@Autowired
	TestService testService;

//	@Autowired
//	LoadBalancerClient loadBalancerClient;
//
//	@Autowired
//	DiscoveryClient discoveryClient;

	public static void main(String[] args) {
		SpringApplication.run(Cloudservice2Application.class, args);
	}

	@RequestMapping(value="/node", method = RequestMethod.GET)
	public String testServiceNode(){
		 //return restTemplate.getForObject("http://cloudservice1/cloud", String.class);
		return testService.testCloud();
	}

	@RequestMapping(value="enum", method = RequestMethod.GET)
	public String testEnumNode(){
		System.out.println("enum begin:");
		return testService.testEnum("apple");
	}

	@RequestMapping(value="person", method = RequestMethod.GET)
	public Person testClassNode(){
		Person person = new Person();
		person.setName("zhang");
		person.setAge(10);
		Person newPerson = testService.testClass(person);
		return newPerson;
	}

	@RequestMapping(value="obj", method = RequestMethod.GET)
	public Map testObj(){
		Map map = new HashMap<>();
		Person person = new Person();
		person.setName("li");
		person.setAge(20);
		map = testService.testObj(person);
		return map;
	}

//	/**
//	 * 从所有服务中选择一个服务（轮询）
//	 */
//	@RequestMapping("/discover")
//	public Object discover() {
//		return loadBalancerClient.choose("tomcat").getUri().toString();
//	}
//
//	/**
//	 * 获取所有服务
//	 */
//	@RequestMapping("/services")
//	public Object services() {
//		return discoveryClient.getInstances("tomcat");
//	}

}
