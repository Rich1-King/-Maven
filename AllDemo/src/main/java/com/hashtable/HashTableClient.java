package com.hashtable;

/**
 * Created by sunchong on 2017/2/18.
 */
public class HashTableClient{

    public static void main(String[] args){
        HashData[] hashDatas = new HashData[10];
        insert(hashDatas, 15);
        insert(hashDatas, 25);
        insert(hashDatas, 35);
        delete(hashDatas, 25);
        insert(hashDatas, 3);
        if(null != find(hashDatas, 11)){
            System.out.println("hashData.value:" + find(hashDatas,11).getData());

        }

    }

    public static boolean insert(HashData[] hashDatas, Integer value){
        if(null == hashDatas){
            return false;

        }

        if(null == hashDatas[value % 10]){
            hashDatas[value % 10] = new HashData();
            hashDatas[value % 10].setData(value);
            return true;

        }
        HashData hashData = hashDatas[value % 10];
        while(null != hashData.getHashData()){
            if(value.equals(hashData.getData())){
                return true;
            }
            hashData = hashData.getHashData();

        }

        if(value.equals(hashData.getData())){
            return true;

        }

        hashData.setHashData(new HashData());
        hashData.getHashData().setData(value);
        return true;

    }

    public static HashData find(HashData[] hashDatas, Integer value){
        if(null == hashDatas){
            return null;

        }

        if(null == hashDatas[value % 10]){
            return null;

        }
        HashData hashData = hashDatas[value % 10];
        while(!value.equals(hashData.getData())){
            hashData = hashData.getHashData();

        }
        return hashData;
    }

    public static boolean delete(HashData[] hashDatas, Integer value){
        if(null == hashDatas){
            return false;

        }

        if(null == hashDatas[value % 10]){
            return false;

        }
        HashData hashData = hashDatas[value % 10];
        if(value.equals(hashData.getData())){
            hashDatas[value % 10] = hashData.getHashData();

        }

        while(!value.equals(hashData.getHashData().getData())){
            hashData = hashData.getHashData();

        }

        hashData.setHashData(hashData.getHashData().getHashData());
        return true;
    }
}
