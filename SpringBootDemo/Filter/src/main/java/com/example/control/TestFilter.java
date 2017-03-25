package com.example.control;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by rich1 on 9/16/16.
 */
@RestController
public class TestFilter{

    @RequestMapping(value = "filter",method = RequestMethod.GET)
    public String testFilter(){
        System.out.println("control被调用");
        return "control被调用";
    }
}
