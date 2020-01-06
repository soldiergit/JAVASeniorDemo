package com.soldier;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * @ProjectName:JAVA-Senior-Demo
 * @author:soldier
 * @Email:583403411@qq.com
 * @create:20-1-6上午8:35
 * @Describe:MongoDB工具类
 **/
public class MongoDBUtil {

    private static MongoClient mongoClient = null;

    static {
        //  单例模式
        if (mongoClient == null) {
            mongoClient = new  MongoClient("127.0.0.1", 27017);
        }
    }

    /**
     * 获取MongoDB数据库
     */
    public static MongoDatabase getDatabase (String dbName) {
        return mongoClient.getDatabase(dbName);
    }

    /**
     * 获取MongoDB数据库
     */
    public static MongoCollection getCollection (String dbName, String collectionName) {
        MongoDatabase database = getDatabase(dbName);
        return database.getCollection(collectionName);
    }
}
