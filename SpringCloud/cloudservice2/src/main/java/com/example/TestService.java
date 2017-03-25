package com.example;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Created by sunchong on 2016/10/17.
 */
@FeignClient("http://cloudservice1/")
public interface TestService{

    @RequestMapping(value="cloud", method = RequestMethod.GET)
    String testCloud();

    @RequestMapping(value="enum", method = RequestMethod.GET)
    String testEnum(@RequestParam(value = "food", required = false) String food);

    @RequestMapping(value="obj", method = RequestMethod.POST)
    Map testObj(@RequestBody Person person);

    @RequestMapping(value="class", method = RequestMethod.POST)
    Person testClass(@RequestBody Person person);
}
