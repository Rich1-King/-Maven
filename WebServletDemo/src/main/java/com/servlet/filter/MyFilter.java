package com.servlet.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by rich1 on 5/6/17.
 */
//filter在web.xml中配置
public class MyFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException{
        System.out.println("filter初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest,ServletResponse servletResponse,FilterChain filterChain) throws IOException, ServletException{
        System.out.println("filter过滤时候调用");
    }

    @Override
    public void destroy(){
        System.out.println("filter销毁的时候调用");
    }
}
