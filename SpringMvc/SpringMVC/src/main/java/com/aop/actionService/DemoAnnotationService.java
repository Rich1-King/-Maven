package com.aop.actionService;

import com.aop.action.Human;
import org.springframework.stereotype.Service;

/**
 * Created by rich1 on 7/18/16.
 */
@Service
public class DemoAnnotationService{
    @Human(name = "hello")
    public void add()
    {

        System.out.println("注释添加一个");

    }

}
