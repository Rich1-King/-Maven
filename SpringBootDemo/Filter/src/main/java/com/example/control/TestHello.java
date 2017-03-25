package com.example.control;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by rich1 on 9/16/16.
 */
@RestController
public class TestHello{

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String sayHello(){
        System.out.println("hello everyDay");
        return "hello everyDay";
    }
}
