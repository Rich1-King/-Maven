package com.redisDemo;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by rich1 on 11/27/16.
 */
public class RedisConfig{

    static JedisPool jedisPool = null;

    public void conection(){
        Jedis jedis = new Jedis("127.0.0.1",6379);
        System.out.println(jedis.ping());
    }

    //初始化连接池
    public void initPool(){
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        //jedis的最大分配对象
        poolConfig.setMaxActive(300);
        //jedis最大保存idel状态对象数
        poolConfig.setMaxIdle(1000);
        //jedis池没有对象返回时，最大等待时间
        poolConfig.setMaxWait(1500);
        //jedis调用borrowObject方法时，是否进行有效检查
        poolConfig.setTestOnBorrow(true);
        //jedis调用returnObject方法时，是否进行有效检查
        poolConfig.setTestOnReturn(true);
        jedisPool = new JedisPool(poolConfig, "127.0.0.1", 6379);
    }

    //获取Jedis
    public Jedis getJedis(){
        System.out.println(jedisPool.getResource().ping());
        return jedisPool.getResource();
    }

    //归还Jedis
    public void returnJedis(Jedis jedis){
         jedisPool.returnResource(jedis);
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
        jedis.lpush("list1", "1","hello","hello2");
        jedis.lpush("list2", "2");
        jedis.lpush("list3", "3");

        //lpush是栈，先进后出，所以取到的会是hello2，hello
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

        jedis.rpush("list", "list1");
        jedis.rpush("list", "list2");
        jedis.rpush("list", "list3");

        System.out.println("//////////////////////");
        //rpush的是队列，先进先出,所以获取到的是list1, list2
        List<String> listStr = jedis.lrange("list", 0, 1);
        System.out.println(listStr.size());
        for(int i=0; i<listStr.size(); i++){
            System.out.println(listStr.get(i));
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

    public void setCacheTime(int time) throws InterruptedException{
        Jedis jedis = new Jedis("localhost");
        jedis.setex("cache", time, "hello word"); //设置time秒后过期
        Thread.sleep(time*1000l - 1000l); //线程休眠3秒
        System.out.println(jedis.get("cache"));
    }

    public void setNull(){
        Jedis jedis = new Jedis("localhost");
        System.out.println(jedis.get("name"));
        System.out.println(jedis.get("age"));
        System.out.println("flushDB:"+jedis.flushDB());
        System.out.println("之后：");
        System.out.println(jedis.get("name"));
        System.out.println(jedis.get("age"));
    }

    public void setKeyExpired(String key, int time){
        Jedis jedis = new Jedis("localhost");
        jedis.expire(key, time);
    }

}
