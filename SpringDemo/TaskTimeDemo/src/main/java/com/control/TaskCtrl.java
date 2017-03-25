package com.control;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sunchong on 2016/7/29.
 */
@RestController
public class TaskCtrl{

    @RequestMapping("/word")
    public String sayWord(){
        return "It is a word!!";
    }
}
