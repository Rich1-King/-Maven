package com.aop.actionService;

import org.springframework.stereotype.Service;

/**
 * Created by rich1 on 7/18/16.
 */
@Service
public class DemoMethodService{

    public void add(){
        System.out.println("方法添加一个");
    }

}
