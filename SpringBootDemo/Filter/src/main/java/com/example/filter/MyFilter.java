package com.example.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 用注解添加过滤器
 * Created by rich1 on 9/16/16.
 */
//@WebFilter(filterName = "myFilter",urlPatterns = "/*") //用该注解就可以不用配置过滤器配置文件
// (例如FilterConf)，但是需要在main方法的类上加入注解@ServletComponentScan
public class MyFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException{
        System.out.println("初始化过滤器");
        filterConfig.getServletContext().addFilter("*",this);
    }

    @Override
    public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain) throws IOException, ServletException{
        System.out.println("执行过滤操作");
        HttpServletRequest httpServletRequest = (HttpServletRequest)request;
        HttpServletResponse httpServletResponse = (HttpServletResponse)
                response;
        System.out.println(httpServletRequest.getRequestURL());
        /*httpServletRequest.getRequestDispatcher
                ("http://localhost:8080/hello").forward(request,response);*/
        if(!httpServletRequest.getRequestURI().equals("/hello.html")){
            httpServletResponse.sendRedirect("http://localhost:8080/hello.html");
        }
        System.out.println(httpServletRequest.getRequestURI());

        chain.doFilter(httpServletRequest,httpServletResponse);
    }

    @Override
    public void destroy(){
        System.out.println("过滤器销毁");
    }
}
