package com.JsonWithObjectConvert;

/**
 * Created by sunchong on 2016/11/8.
 */
public class Person{

    //@JsonProperty(value = "p_name")
    private String pName;

    //@JsonProperty(value = "p_age")
    private Integer pAge;

    private String sex;

    public String getpName(){
        return pName;
    }

    public void setpName(String pName){
        this.pName = pName;
    }

   public Integer getpAge(){
        return pAge;
    }

    public void setpAge(Integer pAge){
        this.pAge = pAge;
    }
}
