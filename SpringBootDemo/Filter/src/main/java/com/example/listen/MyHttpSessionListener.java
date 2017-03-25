package com.example.listen;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by rich1 on 9/16/16.
 */
@WebListener
public class MyHttpSessionListener implements HttpSessionListener{
    @Override
    public void sessionCreated(HttpSessionEvent se){
        System.out.println("Session被创建");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se){
        System.out.println("Session被销毁");
    }
}
