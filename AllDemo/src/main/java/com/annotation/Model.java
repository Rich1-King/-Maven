package com.annotation;

/**
 * Created by sunchong on 2017/2/4.
 */
public class Model{

    @TestAnnotation
    private String defaultName;

    @TestAnnotation(name = "lisi")
    private String name;


    private String noAnnotation;

    public String getNoAnnotation(){
        return noAnnotation;
    }

    public void setNoAnnotation(String noAnnotation){
        this.noAnnotation = noAnnotation;
    }

    public String getDefaultName(){
        return defaultName;
    }

    public void setDefaultName(String defaultName){
        this.defaultName = defaultName;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
