package com.emunm.data;

/**
 * Created by sunchong on 2017/3/17.
 */
public class TypeClient{
    //将字符串转枚举
    public static void main(String[] args){
        Type type;
        try{
            type = Type.valueOf(null);
        }catch (Exception e){
            type = null;
        }
        System.out.println(type);
    }
}
