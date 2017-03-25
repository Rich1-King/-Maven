package com.guava.cache;

import com.google.common.cache.*;
import com.google.gson.Gson;
import com.guava.cache.model.LoginUser;

import java.util.Calendar;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by rich1 on 3/25/17.
 */
public class Cache{
    static Gson gson = new Gson();
    public static void main(String[] args){
        LoadingCache<String, LoginUser> loadingCache = createCacheContainer();
        LoginUser user = new LoginUser();
        user.setPhone("18239506520");
        user.setName("孙崇");
        user.setCreateTime(Calendar.getInstance());
        user.setCount(1);
        try{
            LoginUser loginUser = loadingCache.get(user.getPhone());
            if (null == loginUser){
                loadingCache.put(user.getPhone(),user);
            }
            if (loginUser.getCount() > 3){
                System.out.println(loginUser.getName() + "登录次数超过３次");
            }else{
                Thread.sleep(500l);
                loginUser.setName("王五");
                System.out.println(gson.toJson(loadingCache.get(user.getPhone())));
                //loadingCache.invalidate(loginUser.getPhone());
               // loadingCache.refresh(loginUser.getPhone());
                //System.out.println(gson.toJson(loadingCache.get(user.getPhone())));
                //user.setName("张三");
                //loadingCache.put(user.getPhone(),user);
                Thread.sleep(950l);
                System.out.println(loadingCache.get(user.getPhone()).getName());
            }
        }catch (ExecutionException e){
            e.printStackTrace();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }

    static LoadingCache<String, LoginUser> createCacheContainer(){
        LoadingCache loginCache =
                CacheBuilder.newBuilder()
                        //设置并发级别，并发级别是指可以同时写缓存的线程数
                        .concurrencyLevel(10)
                        //当缓存项在指定的时间段内没有更新就会被回收(refresh会将值变为默认值load方法中的值)
                        //.expireAfterWrite(1,TimeUnit.SECONDS)
                        //当缓存项在指定的时间段内没有被读或写就会被回收
                        .expireAfterAccess(1,TimeUnit.SECONDS)
                        //当缓存项上一次更新操作之后的多久会被刷新
                        //.refreshAfterWrite(1,TimeUnit.SECONDS)
                        //初始化默认大小
                        .initialCapacity(10)
                        //最大的大小，如果大于这个值则会用LRU算法去关闭
                        .maximumSize(100)
                        .recordStats()
                        //移除的时候触动的方法
                        .removalListener(new RemovalListener<Object ,Object>(){
                            @Override
                            public void onRemoval(RemovalNotification<Object, Object> removalNotification){
                                LoginUser loginUser = (LoginUser) removalNotification.getValue();
                                System.out.println(loginUser.getName()+"过期"+removalNotification.getCause());
                            }
                        })
                        //初始化如果缓存中不存在，则默认添加
                        .build(new CacheLoader<String, LoginUser>(){
                            @Override
                            public LoginUser load(String key) throws Exception{
                                //System.out.println("load User" + key);
                                LoginUser loginUser = new LoginUser();
                                loginUser.setPhone(key);
                                loginUser.setCreateTime(Calendar.getInstance());
                                loginUser.setCount(0);
                                return loginUser;
                            }
                        });
        return loginCache;
    }

}
