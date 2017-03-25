package com.captcha;

/**
 * Created by sunchong on 2016/11/7.
 */
public class Client{
    public static void main(String[] args){
        CaptachaUtil captachaUtil = new CaptachaUtil();
        captachaUtil.createCaptha();
        try{
            System.out.println("验证码为:" + captachaUtil.getCode());
            System.out.println("base64:" + captachaUtil.getCaptha());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
