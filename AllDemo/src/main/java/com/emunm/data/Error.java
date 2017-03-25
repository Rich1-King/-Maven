package com.emunm.data;

/**
 * Created by sunchong on 2016/8/5.
 */
public enum Error{
    HELLO_ERROR("错误",1);

    private String str;
    private int id;

    public String getStr(){
        return str;
    }

    public void setStr(String str){
        this.str = str;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }
    Error(String str, int id){
        setStr(str);
        setId(id);
    }
}
