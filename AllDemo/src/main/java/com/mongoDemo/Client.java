package com.mongoDemo;

import com.mongodb.MongoClient;

/**
 * Created by rich1 on 11/21/16.
 */
public class Client{
    public static void main(String[] args){
        MongoClient mongoClient = new MongoConfig().getMongoClient();
        new MongoConfig().findAll(mongoClient);
        new MongoConfig().findById(1);
       /* Document document = new Document();
        document.put("_id",3);
        document.put("rootId","0001");
        document.put("name","天堂");
        new MongoConfig().insertOne(document);
        Document document1 = new Document();
        document1.put("_id",1);
        new MongoConfig().deleteOne(document1);*/

        new MongoConfig().count();
        new MongoConfig().gtValue();
    }
}
