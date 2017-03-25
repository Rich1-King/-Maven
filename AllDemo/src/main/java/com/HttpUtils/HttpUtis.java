package com.HttpUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * Created by sunchong on 2016/11/7.
 */
public class HttpUtis{

    private static Logger logger = Logger.getLogger(Logger.class);
    private static JsonParser jsonParser = new JsonParser();

    public static JsonObject getJsonData(String url){

        logger.info("##GET 请求URL 为" + url);
        JsonObject jsonObject = null;
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        HttpGet get = new HttpGet(url);
        try {
            get.setHeader("loop", "null");
            get.setHeader("Content-type", "application/json");
            CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
            HttpResponse resp = closeableHttpClient.execute(get);
            jsonObject = convertResponseBytes2JsonObj(resp);
        } catch (IOException e) {
            logger.error("get请求["+url+"],请求失败");
            e.printStackTrace();
        }
        return jsonObject;
    }

    public static JsonObject postJsonData(String url, String jsonStrData){
        logger.info("# POST JSON 请求URL 为" + url);
        logger.info("# POST JSON 数据为" + jsonStrData);
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        HttpPost post = new HttpPost(url);
        JsonObject jsonObject = null;
        try{
            CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
            HttpEntity entity = new StringEntity(jsonStrData, "UTF-8");
            post.setEntity(entity);
            post.setHeader("Content-type", "application/json");
           // post.setHeader("loop", "null");//
            HttpResponse resp = closeableHttpClient.execute(post);
            jsonObject = convertResponseBytes2JsonObj(resp);
        } catch (IOException e) {
            logger.error("post请求["+url+"],请求失败");
            e.printStackTrace();
        }
        return jsonObject;
    }

    private static JsonObject convertResponseBytes2JsonObj(HttpResponse resp){
        JsonObject jsonObject = null;

        try {
            InputStream respIs = resp.getEntity().getContent();
            byte[] respBytes = IOUtils.toByteArray(respIs);
            String result = new String(respBytes, Charset.forName("UTF-8"));

            if (null == result || result.length() == 0) {
                logger.error("无响应");
            } else {

                logger.debug(result);

                if (result.startsWith("{") && result.endsWith("}")) {
                    jsonObject = (JsonObject) jsonParser.parse(result);
                } else {
                    logger.error("不能转成JSON对象");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

}
