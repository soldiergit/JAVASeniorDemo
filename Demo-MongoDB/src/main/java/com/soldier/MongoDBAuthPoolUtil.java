package com.soldier;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.util.Arrays;

/**
 * @ProjectName:JAVA-Senior-Demo
 * @author:soldier
 * @Email:583403411@qq.com
 * @create:20-1-6上午9:00
 * @Describe:MongoDB池连工具类-支持用户认证
 **/
public class MongoDBAuthPoolUtil {

    private static MongoClient mongoClient = null;

    static {
        //  单例模式
        if (mongoClient == null) {
            //  创建一个链接池构建器
            MongoClientOptions.Builder builder = new MongoClientOptions.Builder();
            builder.connectionsPerHost(10); //每个地址的最大连接数，默认10
            builder.connectTimeout(5000);   //连接超时时间
            builder.socketTimeout(5000);    //读写操作超时时间

            //  创建一个封装用户认证信息：用户名、用户所在数据库、密码【dev是具有读写权限的普通用户， soldier是具有userAdminAnyDatabase权限的管理员】
            MongoCredential credential = MongoCredential.createCredential("dev", "develop", "devpwd".toCharArray());
//            MongoCredential credential = MongoCredential.createCredential("soldier", "admin", "soldierpwd".toCharArray());

            //  封装MongoDB的地址和端口
            ServerAddress serverAddress = new ServerAddress("127.0.0.1", 27017);

//            mongoClient = new MongoClient(serverAddress, credential, builder.build());                //单个MongoDB地址
            mongoClient = new MongoClient(Arrays.asList(serverAddress), credential, builder.build());   //多个MongoDB地址
        }
    }

    /**
     * 获取MongoDB数据库
     * @param dbName    数据库名称
     */
    public static MongoDatabase getDatabase (String dbName) {
        return mongoClient.getDatabase(dbName);
    }

    /**
     * 获取MongoDB中某个数据库的集合
     * @param dbName            数据库名称
     * @param collectionName    该数据库中的集合名称（不存在时自动创建）
     */
    public static MongoCollection getCollection (String dbName, String collectionName) {
        MongoDatabase database = getDatabase(dbName);
        return database.getCollection(collectionName);
    }

    /**
     * 创建集合
     * @param dbName            数据库名称
     * @param collectionName    该数据库中的集合名称（不存在时自动创建）
     */
    public static void createCollection (String dbName, String collectionName) {
        MongoDatabase database = getDatabase(dbName);
        //  在某个数据库中创建集合，当MongoDB数据库开启了用户认证，用户必须至少具备userAdminAnyDatabase权限
        database.createCollection(collectionName);
    }

    /**
     * 删除集合
     * @param coll  集合对象
     */
    public static void dropCollection (MongoCollection coll) {
        //  在某个数据库中删除集合，当MongoDB数据库开启了用户认证，用户必须至少具备userAdminAnyDatabase权限
        coll.drop();
    }
}
