package com.api.controller;

import com.api.model.ReturnBody;
import com.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sunchong on 2017/2/21.
 */
@RestController
@RequestMapping("user")
public class UserController{

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ReturnBody saveUser(){
//        User user = new User();
//        user.setName("zhang");
//        user.setAge(10);
//        user.setSex("man");
//        try{
//            userService.saveUser(user);
//        }catch (Exception e){
//            userService.saveUser(user);
//        }
//        return new ReturnBody(user);
        userService.createUserTable();
        return new ReturnBody();
    }

}
