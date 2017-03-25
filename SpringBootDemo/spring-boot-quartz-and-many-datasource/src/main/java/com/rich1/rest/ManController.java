package com.rich1.rest;

import com.juxinli.demo.quartz.springboot.model.po.db2.Man;
import com.juxinli.demo.quartz.springboot.service.ManService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by sunchong on 2016/12/8.
 */
@RestController
@RequestMapping("man")
public class ManController{
//    @Autowired
    ManService manService;

    @RequestMapping( method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public List<Man> findAll(){
        return manService.findAll();
    }
}
