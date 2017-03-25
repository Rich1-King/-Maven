package com.guava.cache.model;

import java.util.Calendar;

/**
 * Created by rich1 on 3/25/17.
 */
public class LoginUser{
    private String name;
    private String phone;
    private Calendar createTime;
    private Integer count;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getPhone(){
        return phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public Calendar getCreateTime(){
        return createTime;
    }

    public void setCreateTime(Calendar createTime){
        this.createTime = createTime;
    }

    public Integer getCount(){
        return count;
    }

    public void setCount(Integer count){
        this.count = count;
    }
}
