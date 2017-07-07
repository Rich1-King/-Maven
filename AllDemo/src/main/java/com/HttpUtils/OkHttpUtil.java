package com.zgqb.loan.app.util;

import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

import java.io.IOException;

/**
 * Created by schongking on 2017/7/7.
 */
@Slf4j
public class OkHttpUtil {

    public static String postJson(String url, String json){
        log.info(String.format("HttpPostJson的url为：%s, data为：%s", url, json));
        MediaType mediaType = MediaType.parse("application/json; charset=UTF-8");
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = RequestBody.create(mediaType, json);
        Request request = new Request.Builder().url(url).post(requestBody).build();
        try {
            Response response = client.newCall(request).execute();
            if(!response.isSuccessful()){
                log.error(String.format("HttpPostJson的url:%s，请求失败，失败原因：%s", url, response.body().toString()));
                return null;
            }
            log.info(String.format("HttpPostJson的url:%s，请求成功", url));
            return response.body().toString();
        } catch (IOException e) {
            log.error(String.format("HttpPostJson的url:%s，请求异常，异常原因：%s", url, e));
            return null;
        }
    }

    public static String get(String url){
        log.info(String.format("HttpGet请求的url为：%s", url));
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        try {
            Response response = client.newCall(request).execute();
            if(!response.isSuccessful()){
                log.info(String.format("HttpGet请求%s失败，失败原因：", url, response.body().toString()));
                return null;
            }
            return response.body().toString();
        } catch (IOException e) {
            log.info(String.format("HttpGet请求%s异常，异常内容：", url),e);
            return null;
        }
    }

    //异步请求无法获取返回值
    public static void getAsyn(String url){
        log.info(String.format("HttpAsynGet请求的url为：%s", url));
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                log.error(String.format("HttpAsynGet请求url为：%s, 请求异常", url), e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(!response.isSuccessful()){
                    log.error(String.format("HttpAsynGet请求url为：%s, 请求失败,失败原因:%s", url, response.body().toString()));
                }
                log.info(String.format("HttpAsynGet请求url为：%s==>成功",url));
            }
        });
    }

}
