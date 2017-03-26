package com.aop.aspect;

import com.aop.action.Human;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by rich1 on 7/18/16.
 */
@Aspect
@Component
public class LogAspect{

    @Pointcut("@annotation(com.aop.action.Human)")
    public void aspect(){
        System.out.println("I am anotionHumanAspect!!!");
    }

    @After("aspect()")
    public void after(JoinPoint joinPoint){
        MethodSignature methodSignature = (MethodSignature)joinPoint
                .getSignature();
        Method method = methodSignature.getMethod();
        Human human = method.getAnnotation(Human.class);
        System.out.println("111"+human.name());
        System.out.println(method.getName());

    }

    @Before("execution(* com.aop.actionService.DemoMethodService.*(..))")
    public void before(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("222"+method.getName());
    }

}
