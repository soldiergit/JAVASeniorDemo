package com.soldier;

import com.mongodb.client.MongoCollection;

/**
 * @ProjectName:JAVA-Senior-Demo
 * @author:soldier
 * @Email:583403411@qq.com
 * @create:20-1-5上午11:45
 * @Describe:   Java中接MongoDB数据库-直连方式
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

        MongoCollection collection = MongoDBUtil.getCollection("develop", "dev");

        System.out.println("ok......");


    }
}
