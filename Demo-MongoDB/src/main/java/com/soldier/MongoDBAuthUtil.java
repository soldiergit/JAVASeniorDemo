package com.soldier;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.util.Arrays;

/**
 * @ProjectName:JAVA-Senior-Demo
 * @author:soldier
 * @Email:583403411@qq.com
 * @create:20-1-6上午8:35
 * @Describe:MongoDB直连工具类-支持用户认证
 **/
public class MongoDBAuthUtil {

    private static MongoClient mongoClient = null;

    static {
        //  单例模式
        if (mongoClient == null) {
            //  创建一个封装用户认证信息：用户名、所在数据库、密码
            MongoCredential credential = MongoCredential.createCredential("dev", "develop", "devpwd".toCharArray());
            //  封装MongoDB的地址和端口
            ServerAddress serverAddress = new ServerAddress("127.0.0.1", 27017);
            //  这个方法已经过时了，MongoDB更推荐我们使用池连的方式获取链接
            mongoClient = new  MongoClient(serverAddress, Arrays.asList(credential));
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
