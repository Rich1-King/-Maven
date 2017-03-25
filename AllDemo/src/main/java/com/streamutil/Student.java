package com.streamutil;

/**
 * Created by sunchong on 2017/3/7.
 */
public class Student{
    private String sId;
    private String name;
    private Integer age;

    public Student(){}
    public Student(String name,Integer age){
        this.name = name;
        this.age = age;
    }
    public Student(String sId, String name, Integer age){
        this.sId = sId;
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

    public String getsId(){
        return sId;
    }

    public void setsId(String sId){
        this.sId = sId;
    }
}
