package com.extend;
/**
**  author:jack 2017年03月2017/3/9日
*/
public class Child extends Father {

    public String value = "childvalue";
    public static Integer i;

    public void printFather(){
        i=100;
        System.out.println("Child");
    }

    public void sayHello(){
        System.out.println("hello"+i);
    }
}
