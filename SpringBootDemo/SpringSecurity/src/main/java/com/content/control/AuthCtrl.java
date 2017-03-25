package com.content.control;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by rich1 on 10/16/16.
 */
@Controller
public class AuthCtrl{

    @RequestMapping(value ={"/","/home"}, method=RequestMethod.GET)
    @ResponseBody
    public String home(){
        return "home";
    }

    @RequestMapping(value = "/helloadmin", method=RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseBody
    public String helloAdmin(){
        return "helloAdmin";
    }

    @RequestMapping(value = "/hellouser", method= RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_ADMIN','ROLE_USER')")
    @ResponseBody
    public String helloUser(){
        return "helloUser";
    }

    @RequestMapping(value = "/login", method=RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping("/403")
    @ResponseBody
    public String forbidden(){
        return "403";
    }

}
