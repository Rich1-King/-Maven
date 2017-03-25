package com.example.control;

import com.example.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by rich1 on 9/17/16.
 */
@RestController
public class HelloCtrl{

    @Autowired
    HelloService helloService;

    @RequestMapping("hello")
    public String sayHello(){
        return helloService.sayHello();
    }

    @RequestMapping("value")
    public String showWord(){
        return "hello";
    }


}
