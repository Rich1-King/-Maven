package com.authentication;

import com.google.gson.Gson;

/**
 * Created by sunchong on 2016/11/9.
 */
public class Client{
    static Gson gson = new Gson();
    public static void main(String[] args){
        DesUtils desUtils = new DesUtils();
        Authentication authentication = new Authentication();
        try{
            String encStr = desUtils.encrypt(String.valueOf(System.currentTimeMillis()), Key.MKEY);
            System.out.println("加密:"+encStr);
            String desStr = desUtils.decrypt(encStr, Key.MKEY);
            System.out.println("解密:"+desStr);

            authentication.setAuthType(Authentication.AuthType.MANY);
            authentication.setSignTime(System.currentTimeMillis());
            authentication.setToken(encStr);
            AuthData authData = new AuthData();
            authData.setAuth(10);
            authData.setStr("lll");
            authentication.setData(authData);
            String gsonStr = gson.toJson(authentication);
            System.out.println(gsonStr+"\ngsonStr.length:"+gsonStr.length());
            String strEnc = desUtils.encrypt(gsonStr, Key.MKEY);
            System.out.println(strEnc+",\n strEnc.length:"+strEnc.length());
            String data = desUtils.decrypt(strEnc, Key.MKEY);
            System.out.println(data);
            Authentication authentication1 = gson.fromJson(data,Authentication.class);
            System.out.println("");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
