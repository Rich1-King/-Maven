package com.example.control;

import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by rich1 on 9/20/16.
 */
@RestController
public class UserControl{

    @Autowired
    UserService userService;

    @RequestMapping(value="/get", method = RequestMethod.GET)
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @RequestMapping(value="/insert", method = RequestMethod.GET)
    public String insertUser(@RequestParam(required = true) String name,
                              @RequestParam(required = true) int age){
        User user = new User();
        user.setName(name);
        user.setAge(age);
        try{
            userService.insertUser(user);
            return "插入成功";
        }catch (Exception e){
            return "插入失败";
        }
    }

    @RequestMapping(value="/update", method = RequestMethod.GET)
    public String updateUser(@RequestParam(required = true) String name,
                              @RequestParam(required = true) int age){
        User user = new User();
        user.setName(name);
        user.setAge(age);
        try{
            userService.updateUser(user);
            return "更新成功";
        }catch (Exception e){
            return "更新失败";
        }
    }
    @RequestMapping(value="/delete", method = RequestMethod.GET)
    public String deleteUser(@RequestParam(required = true) String name,
                              @RequestParam(required = true) int age){
        User user = new User();
        user.setName(name);
        user.setAge(age);
        try{
            userService.deleteUser(user);
            return "删除成功";
        }catch (Exception e){
            return "删除失败";
        }
    }

}
