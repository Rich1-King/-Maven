package com.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by sunchong on 2017/2/4.
 */
/*
 注解的使用，反射
 */
public class AnnotationClient{

    public static void main(String[] args) throws ClassNotFoundException{
        Class<?> cl = Class.forName("com.annotation.Model");
        Field[] fileds = cl.getDeclaredFields();
        for(Field field : fileds){
            field.setAccessible(true);
            boolean flag = field.isAnnotationPresent(com.annotation.TestAnnotation.class);
            if(flag){
                System.out.println(field.getName()+":"+flag);
            }else{
                System.out.println(field.getName()+":"+flag);
            }
        }
        Method[] methods = cl.getMethods();
        System.out.println("");
    }

}
