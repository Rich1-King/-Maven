package com.example.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by rich1 on 9/16/16.
 */
@Controller
public class TestInterceptorCtrl{

    @RequestMapping(value = "testinterceptor", method = RequestMethod.GET)
    @ResponseBody
    public String testInterceptor(){
        System.out.println("拦截器测试");
        return "拦截器测试";
    }
}
