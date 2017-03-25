package com.HttpUtils;

/**
 * Created by sunchong on 2017/2/18.
 */
public class UrlClient{
    public static void main(String[] args){
        try{
            System.out.println("Get请求:");
            UrlUtils.get("https://www.zhihu.com/");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
