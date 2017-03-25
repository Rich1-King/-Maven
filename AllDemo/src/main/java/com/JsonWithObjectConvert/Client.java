package com.JsonWithObjectConvert;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.*;

/**
 * Created by sunchong on 2016/11/8.
 */
public class Client{
    private static Logger logger = Logger.getLogger(Logger.class);

    public static void main(String[] args){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
        try{

            String jsonStr = "{\"p_name\":\"zhagsan\",\"p_age\":10}";

            JsonParser jsonParser = new JsonParser();
            JsonObject jsonPerson = jsonParser.parse(jsonStr).getAsJsonObject();
            System.out.println(jsonPerson.get("p_name").getAsString());

            Person person = objectMapper.readValue(jsonStr, Person.class);
            System.out.println("json=>object,name:" + person.getpName() + ",age:" + person.getpAge());

            Gson gson = new Gson();
            String jsonStr1 = "{\"pAame\":\"zhagsan\",\"pAge\":10}";//按名字匹配
            Person pGson = gson.fromJson(jsonStr1,Person.class);
            System.out.println("gson>json=>object,name:" + pGson.getpName() + ",age:" + pGson.getpAge());

            String jsonStrs = "[{\"p_name\":\"zhagsan\",\"p_age\":10},{\"p_name\":\"liuer\",\"p_age\":15}]";
            Person[] persons = objectMapper.readValue(jsonStrs, Person[].class);
            List<Person> personList = Arrays.asList(persons);
            for(Person p : personList){
                System.out.println("List||json=>object,name:"+p.getpName()+",age:"+p.getpAge());
            }

            JavaType javaType = objectMapper.getTypeFactory().constructParametricType(List.class, Person.class);
            List<Person> personList1 = objectMapper.readValue(jsonStrs,javaType);
            for(Person p : personList1){
                System.out.println("List1||json=>object,name:"+p.getpName()+",age:"+p.getpAge());
            }

            String jsonStrs1 = "[{\"pName\":\"zhagsan\",\"pAge\":10},{\"pName\":\"liuer\",\"pAge\":15}]";
            List<Person> personList2 = gson.fromJson(jsonStrs1, new TypeToken<List<Person>>(){}.getType());
            for(Person p : personList2){
                System.out.println("List2||json=>object,name:"+p.getpName()+",age:"+p.getpAge());
            }

            Person[] persons1 = gson.fromJson(jsonStrs, Person[].class);
            List<Person> personList3 = Arrays.asList(persons);
            for(Person p : personList3){
                System.out.println("List3||json=>object,name:"+p.getpName()+",age:"+p.getpAge());
            }

            //对象转json
            Person person1 = new Person();
            person1.setpName("1");
            person1.setpAge(12);
            String json1 = objectMapper.writeValueAsString(person1);
            System.out.println(json1);

            Gson gson1 = new Gson();
            String str = gson1.toJson(person);
            System.out.println(str);

            List<Map> mapList = new ArrayList<Map>();
            Map map6 = new HashMap();
            map6.put("name", 6);
            map6.put("data", "hello");
            Map map5 = new HashMap();
            map5.put("name", 5);
            map5.put("data", map6);
            Map map4 = new HashMap();
            map4.put("name", 4);
            map4.put("data", map5);
            Map map3 = new HashMap();
            map3.put("name", 3);
            map3.put("data", map4);
            Map map2 = new HashMap();
            map2.put("name","2");
            map2.put("data",map3);
            Map map1 = new HashMap();
            map1.put("name", "1");
            map1.put("data", map2);
            Map map = new HashMap();
            map.put("name","0");
            map.put("data", map1);

            mapList.add(map);
            Map map7 = new HashMap();
            map7.put("test", "test");
            mapList.add(map7);

            String strJson = objectMapper.writeValueAsString(mapList);
            System.out.println(strJson);
            Map[] maps = objectMapper.readValue(strJson, Map[].class);

        }catch (IOException e){
            logger.error("转换失败");
            e.printStackTrace();
        }
    }
}
