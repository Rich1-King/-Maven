package com.memcached;

import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;

import java.util.Date;

/**
 * Created by rich1 on 5/29/17.
 */
public class Client{

    protected static MemCachedClient mcc = new MemCachedClient();

    static{
        String[] servers = {"127.0.0.1:11211"};
        Integer[] weights = { 3 };

        SockIOPool pool = SockIOPool.getInstance();

        pool.setServers(servers);
        pool.setWeights(weights);

        pool.setInitConn(5);
        pool.setMinConn(5);
        pool.setMaxConn(250);
        pool.setMaxIdle(1000*60*60*6);

        pool.setMaintSleep(30);

        pool.setNagle(false);
        pool.setSocketTO(3000);
        pool.setSocketConnectTO(0);
        pool.initialize();
    }

    public static void main(String[] args) throws InterruptedException{
        Date date = new Date();
        date.setTime(3000);

        mcc.set("name", "zhangsan", date);
        System.out.println("first:"+mcc.get("name"));
        Thread.sleep(4000l);
        System.out.println("second:"+mcc.get("name"));
    }

}
