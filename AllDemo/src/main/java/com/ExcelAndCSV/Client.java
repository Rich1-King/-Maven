package com.ExcelAndCSV;

import com.HttpUtils.HttpUtis;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by sunchong on 2016/11/15.
 */
public class Client{
    public static void main(String[] args){
        ExcelAndCSVUtils excelAndCSVUtils = new ExcelAndCSVUtils();
        List<Map> mapList = excelAndCSVUtils.readCSV();

        String url = "http://www.tianyancha.com/search/";
        String trueUrl = "http://www.tianyancha.com/company/";
        //String key = "上海维信荟智金融科技有限公司";
        String checkFrom = ".json";
       List<Map> newMap = new ArrayList<Map>();
        try{
            for(int i=0; i<mapList.size(); i++){
                String key = deleteTwoQuotationsOfString(mapList.get(i).get("companyName").toString());
                String strUrl = url + key + checkFrom;
                String regNumber = "";
                String trueValue = "";
                JsonObject jsonObject;
                JsonArray jsonArray;
                JsonObject jsonObject1;
                try{
                    jsonObject = HttpUtis.getJsonData(strUrl);
                    jsonArray = jsonObject.get("data").getAsJsonArray();
                    jsonObject1 = jsonArray.get(0).getAsJsonObject();
                    regNumber = jsonObject1.get("regNumber").toString();
                    trueValue = jsonObject1.get("id").toString();
                }catch (Exception e){
                    System.out.println("null:"+i);
                    try{
                        jsonObject = HttpUtis.getJsonData(strUrl);
                        jsonArray = jsonObject.get("data").getAsJsonArray();
                        jsonObject1 = jsonArray.get(0).getAsJsonObject();
                        regNumber = deleteTwoQuotationsOfString(jsonObject1.get("regNumber").toString());
                        trueValue = deleteTwoQuotationsOfString(jsonObject1.get("id").toString());
                    }catch (Exception e1){
                        System.out.println("meishuju:"+key+" "+i);
                    }
                }
                mapList.get(i).put("businessRegistrationNumber", regNumber);
                mapList.get(i).put("additionalInformation", trueUrl+trueValue);
                Thread.sleep(2000);
                System.out.println(key+":"+i);
                newMap.add(mapList.get(i));
              //  get(url1 + checkFrom);
            }
            System.out.println("hello");
            excelAndCSVUtils.writeExcel(newMap);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void get(String url) throws Exception{
        System.out.println("请求url为:" + url);
        URL urlGet = new URL(url);
        HttpURLConnection con = (HttpURLConnection) urlGet.openConnection();
        con.setConnectTimeout(100000);
        con.setRequestProperty("Connection","Keep-Alive");
        //con.setRequestProperty("loop","null");
        // con.addRequestProperty("loop","null");获取编号需要
        con.setRequestMethod("GET");
        //con.setDoInput(true);
        //con.setDoOutput(true);
        //con.connect();
        System.out.println("返回参数为:");
        int ch;
        while ((ch = con.getInputStream().read()) != -1){
            System.out.print((char) ch);
        }
    }

    /**
     * 如果字符串开头和结尾具有引号，那么将两边的引号删除
     * @param str
     */
    public static String deleteTwoQuotationsOfString(String str){
        if(str.indexOf("\"")==0){
            str = str.substring(1,str.length());
        }
        if(str.lastIndexOf("\"")==(str.length()-1)){
            str = str.substring(0,str.length() - 1);
        }
        return str;
    }
}
