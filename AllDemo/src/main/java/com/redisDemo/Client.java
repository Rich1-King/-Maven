package com.redisDemo;

/**
 * Created by rich1 on 11/27/16.
 */
public class Client{
    public static void main(String[] args){
        RedisConfig redisConfig = new RedisConfig();
        redisConfig.conection();

        //redisConfig.setString();
        //redisConfig.setList();
        redisConfig.getKey();
    }
}
