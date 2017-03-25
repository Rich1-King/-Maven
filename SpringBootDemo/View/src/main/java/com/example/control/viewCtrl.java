package com.example.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by rich1 on 10/16/16.
 */
@Controller
public class viewCtrl{
    @RequestMapping(value="html",method = RequestMethod.GET)
    public String viewHtml(){
        return "hello";
    }

    @RequestMapping(value="jsp",method = RequestMethod.GET)
    public String viewJsp(){
        return "index";
    }
}
