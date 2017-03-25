package com.extend;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
**  author:jack 2017年03月2017/3/9日
*/
public class Test {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException{
        Father obj = new Child();
        System.out.println(obj.value);
        Method[] methods = obj.getClass().getMethods();
        Field[] fields = obj.getClass().getFields();
        obj.printFather();
        methods[1].invoke(obj);
        Child child = new Child();
        System.out.println(child.value);
        child.printFather();
        Class cs = child.getClass();
        Method[] childMethods = child.getClass().getMethods();
        Field[] childFleds = child.getClass().getFields();
        System.out.println("over");
    }
}
