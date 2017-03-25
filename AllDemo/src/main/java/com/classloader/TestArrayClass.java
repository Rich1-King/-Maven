package com.classloader;

/**
 * Created by sunchong on 2017/2/4.
 */
public class TestArrayClass{
    static {
        System.out.println("TestArrayClass is class");
    }

    private String properties1;

    public TestArrayClass(){}


    public String getProperties1(){
        return properties1;
    }

    public void setProperties1(String properties1){
        this.properties1 = properties1;
    }
}
