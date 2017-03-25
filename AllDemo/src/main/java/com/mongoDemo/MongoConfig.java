package com.mongoDemo;

import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.BsonDocument;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rich1 on 11/21/16.
 */
public class MongoConfig{
    public MongoClient getMongoClient(){
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        return mongoClient;
    }

    /**
     * ｍｏｎｇｏｄｂ连接池
     * @return
     */
    public MongoClient getMongoClientIsPool(){
        MongoClientOptions.Builder builder = new MongoClientOptions.Builder();
        builder.connectionsPerHost(100);// 与目标数据库可以建立的最大链接数
        builder.connectTimeout(1000 * 60 * 20);// 与数据库建立链接的超时时间
        builder.maxWaitTime(100 * 60 * 5);// 一个线程成功获取到一个可用数据库之前的最大等待时间
        builder.threadsAllowedToBlockForConnectionMultiplier(100);
        builder.maxConnectionIdleTime(0);
        builder.maxConnectionLifeTime(0);
        builder.socketTimeout(0);
        builder.socketKeepAlive(true);
        MongoClientOptions myOptions = builder.build();
        MongoClient mongoClient = new MongoClient(new ServerAddress("127.0.0.1", 27017),
                 myOptions);
        return mongoClient;
    }

    public MongoClient getMongoCientByUser(){

        ServerAddress serverAddress = new ServerAddress("localhost",27017);
        List<ServerAddress> addrs = new ArrayList<ServerAddress>();
        addrs.add(serverAddress);

        //MongoCredential.createScramSha1Credential()三个参数分别为 用户名 数据库名称 密码
        MongoCredential credential = MongoCredential.createScramSha1Credential("username", "databaseName", "password".toCharArray());
        List<MongoCredential> credentials = new ArrayList<MongoCredential>();
        credentials.add(credential);

        //通过连接认证获取MongoDB连接
        MongoClient mongoClient = new MongoClient(addrs,credentials);
        return mongoClient;
    }

    public void findAll(MongoClient mongoClient){
        MongoDatabase mongoDatabase = mongoClient.getDatabase("demo");
        MongoCollection<org.bson.Document> document = mongoDatabase.getCollection("person");
        FindIterable findIterable = document.find();
        MongoCursor mongoCursor = findIterable.iterator();
        while(mongoCursor.hasNext()){
            Object o = mongoCursor.next();
            if(o instanceof Document){
                Document document1 = (Document) o;
                System.out.println(document1.get("_id"));
            }
            System.out.println(mongoCursor.next().toString());
            //System.out.println(mongoCursor.next());
        }
        mongoCursor.close();
        mongoClient.close();
    }

    public void findById(int id){
        MongoClient mongoClient = getMongoClient();
        MongoDatabase mongoDatabase = mongoClient.getDatabase("demo");
        MongoCollection mongoCollection = mongoDatabase.getCollection("person");
        BsonDocument bsonDocument = new BsonDocument();
        Document document = new Document("_id",id);
        FindIterable findIterable = mongoCollection.find(document);
        MongoCursor mongoCursor = findIterable.iterator();
        while (mongoCursor.hasNext()){
            Object o = mongoCursor.next();
            if(o instanceof Document){
                Document document1 = (Document)o;
                System.out.println(document1.get("name").toString());
                System.out.println(document1.get("age").toString());
                System.out.println(document1.get("sex").toString());
                System.out.println(document1.toJson());
            }
        }
        mongoCursor.close();
        mongoClient.close();
    }

    public void insertOne(Document document){
        MongoClient mongoClient = getMongoClient();
        MongoDatabase db = mongoClient.getDatabase("demo");
        MongoCollection mongoCollection = db.getCollection("person");
        mongoCollection.insertOne(document);
        mongoClient.close();
    }

    public void deleteOne(Document document){
        MongoClient mongoClient = getMongoClient();
        MongoDatabase db = mongoClient.getDatabase("demo");
        MongoCollection mongoCollection = db.getCollection("person");
        mongoCollection.deleteOne(document);
        mongoClient.close();
    }

    public void count(){
        MongoClient mongoClient = getMongoClient();
        MongoDatabase db = mongoClient.getDatabase("demo");
        MongoCollection mongoCollection = db.getCollection("person");
        System.out.println(mongoCollection.count());
        mongoClient.close();
    }

    public void gtValue(){
        MongoClient mongoClient = getMongoClient();
        MongoDatabase db = mongoClient.getDatabase("demo");
        MongoCollection mongoCollection = db.getCollection("person");
        Document document = new Document().append("_id", new Document
                (QueryOperators.GT, 2));
        FindIterable findIterable = mongoCollection.find(document);
        MongoCursor mongoCursor = findIterable.iterator();
        while (mongoCursor.hasNext()){
            Document document1 = (Document) mongoCursor.next();
            System.out.println(document1.get("_id"));
            System.out.println(document1.get("rootId"));
            System.out.println(document1.get("name"));
            System.out.println(document1.toJson());
        }
        mongoCursor.close();
        mongoClient.close();
    }


}
