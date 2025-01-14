package com.example.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by rich1 on 9/16/16.
 */
public class Interceptor1 implements HandlerInterceptor{
    /**
     * 拦截器先进入该方法
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,Object o) throws Exception{

        System.out.println("在请求处理之前进行调用（Controller方法调用之前）");
        if(httpServletRequest.getRequestURI().contains("testinterceptor")){
            return false; //返回false取消当前请求
        }
        return true; //只有返回true才会继续向下执行，返回false取消当前请求
    }

    /**
     * 请求处理之后，渲染页面之前调用,control处理之后执行
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,Object o,ModelAndView modelAndView) throws Exception{
        System.out.println("请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）");
    }

    /**
     * 最后执行，页面渲染之后执行
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,Object o,Exception e) throws Exception{
        System.out.println("在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）");
    }
}
