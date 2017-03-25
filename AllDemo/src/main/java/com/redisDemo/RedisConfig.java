package com.redisDemo;

import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by rich1 on 11/27/16.
 */
public class RedisConfig{

    public void conection(){
        Jedis jedis = new Jedis("127.0.0.1",6379);
        System.out.println(jedis.ping());
    }

    public void setString(){
        Jedis jedis = new Jedis("localhost");
        jedis.set("name","zhangsan");
        jedis.set("age","10");
        System.out.println(jedis.get("name"));
        System.out.println(jedis.get("age"));
    }

    public void setList(){
       Jedis jedis = new Jedis("localhost");
        jedis.lpush("list1", "1","hello");
        jedis.lpush("list2", "2");
        jedis.lpush("list3", "3");

        List<String> list = jedis.lrange("list1", 0,1);
        for(int i=0; i<list.size(); i++){
            System.out.println(list.size());
            System.out.println(list.get(i));
        }
        System.out.println("//////////////////////");
        List<String> list1 = jedis.lrange("list2",0,0);
        for(int i=0; i<list1.size(); i++){
            System.out.println(list1.size());
            System.out.println(list1.get(i));
        }
    }

    public void getKey(){
        Jedis jedis = new Jedis("localhost");
        Set<String> list = jedis.keys("*");
        System.out.println(jedis.get("name"));
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }



}
