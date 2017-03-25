package com.example.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by rich1 on 9/17/16.
 */
@Service
@Transactional    //事物处理
public class HelloService{

    public String sayHello(){
        return "hello";
    }
}
