package com.streamutil;

/**
 * Created by sunchong on 2017/3/8.
 */
public class Person{
    private String name;
    private Integer age;
    public Person(){}
    public Person(String name, Integer age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Integer getAge(){
        return age;
    }

    public void setAge(Integer age){
        this.age = age;
    }
}
