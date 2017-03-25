package com.MapDemo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by sunchong on 2016/12/23.
 */
public class MapIterator{

    public static void main(String[] args){
        Map map = new HashMap();
        map.put("1", "hello");
        map.put("2", ",");
        map.put("3", "word");
        Iterator setIterator = map.entrySet().iterator();
        Iterator iterator = map.keySet().iterator();
        Iterator colIterator = map.values().iterator();
        Object[] setObj = map.entrySet().toArray(); //转数组map
        Object[] obj = map.keySet().toArray();//转key对应的数组
        Object[] colObj = map.values().toArray(); //转value对应的数组
        while(iterator.hasNext()){
            //key
            System.out.println(iterator.next().toString());
        }
        while(setIterator.hasNext()){
            //key=value
            System.out.println(setIterator.next().toString());
        }
        while(colIterator.hasNext()){
            //value
            System.out.println(colIterator.next().toString());
        }
    }
}
