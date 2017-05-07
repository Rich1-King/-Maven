package com.servlet.listen;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by rich1 on 5/6/17.
 */
//监听器配置在web.xml中，因为监听器是容器自己的内容
public class MyServletContextListener implements ServletContextListener{
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent){
        //每次创建容器的时候就会创建ServletContext对象，一个容器该对象只会存在一个,所以可以用Servlet进行通信，全局变量
        ServletContext servletContext = servletContextEvent.getServletContext();
        //用servletContext获得参数
        System.out.println(servletContext.getInitParameter("age"));
        //创建容器的时候调用
        System.out.println("MyServletContextListener 初始化启动");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent){
        //销毁容器时调用
        System.out.println("MyServletContextListener 销毁");
    }
}
