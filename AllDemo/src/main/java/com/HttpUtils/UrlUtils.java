package com.HttpUtils;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by sunchong on 2017/2/18.
 */
public class UrlUtils{

    public static void get(String urlStr) throws Exception{
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Connection", "Keep-Alive");
        System.out.println("请求的url为:" + urlStr);
        System.out.println("返回的参数:");
        int ch;
        while((ch = conn.getInputStream().read()) != -1){
            System.out.print((char) ch);
        }
    }

    public static void post(String urlStr, String params) throws Exception{
        String result = "";

        try{
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(100000);
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            System.out.println("请求的参数为："+params);
            conn.getOutputStream().write(new String(params.getBytes(),
                    "utf-8").getBytes());

            System.out.print("返回的参数为：");
            int ch;
            while((ch = conn.getInputStream().read())!=-1){
                System.out.print((char)ch);
            }

        }catch (Exception e){
            System.out.println("出错："+e);
        }
    }
}
