package com.soldier;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * @ProjectName:JAVA-Senior-Demo
 * @author:soldier
 * @Email:583403411@qq.com
 * @create:20-1-5上午11:45
 * @Describe:   MongoDB数据库操作
 **/
public class MongoDBDemo {

    public static void main(String[] args) {
//        //  创建连接对象
//        MongoClient mongoClient = new MongoClient("127.0.0.1", 27017);
//
//        //  获取MongoDB数据库
//        MongoDatabase database = mongoClient.getDatabase("develop");
//
//        //  获取MongoDB中的集合
//        MongoCollection collection = database.getCollection("dev");

//        MongoCollection collection = MongoDBUtil.getCollection("develop", "dev");

//        MongoCollection collection = MongoDBAuthUtil.getCollection("develop", "dev");

//        MongoCollection collection = MongoDBPoolUtil.getCollection("develop", "dev");

//        MongoCollection collection = MongoDBAuthPoolUtil.getCollection("develop", "dev");
//        System.out.println("获取数据库链接成功......");

        MongoDatabase database = MongoDBAuthPoolUtil.getDatabase("develop");
        //  在某个数据库中创建集合，当MongoDB数据库开启了用户认证，用户必须至少具备userAdminAnyDatabase权限
//        database.createCollection("test");
        MongoCollection collection = database.getCollection("test");
//        System.out.println(collection.getNamespace());
        MongoDBAuthPoolUtil.dropCollection(collection);
    }
}
