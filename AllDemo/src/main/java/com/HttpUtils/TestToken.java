package com.HttpUtils;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.Calendar;

/**
 * Created by sunchong on 2016/11/23.
 */
public class TestToken{

    public static void main(String[] args){
        while(true){
            JsonObject jsonObject = HttpUtis.getJsonData("");
            if(jsonObject == null && jsonObject.get("data") == null){
                continue;
            }
            JsonObject jsonObject1 = jsonObject.get("data").getAsJsonObject();
            if(jsonObject1 == null || jsonObject1.get("details")==null){
                continue;
            }
            JsonArray jsonArray = jsonObject1.get("details").getAsJsonArray();
            if(jsonArray == null || jsonArray.size() <= 0){
                continue;
            }
            JsonObject jsonObject2 = jsonArray.get(0).getAsJsonObject();
            if(jsonObject2 == null || jsonObject2.get("websiteStatus") == null){
                continue;
            }
            if ("SUCCESS".equals(jsonObject2.get("websiteStatus").getAsString())){
                long long1 = Calendar.getInstance().getTimeInMillis();
                System.out.println("开始:" + long1);
                JsonObject jsonObject3 = HttpUtis.getJsonData("");
                System.out.println(jsonObject3.toString());
                long long2 = Calendar.getInstance().getTimeInMillis();
                System.out.println("结束:" + long2);
                //break;
            }
        }
    }

}
