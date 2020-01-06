package com.soldier.document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.soldier.MongoDBAuthPoolUtil;
import org.bson.Document;

/**
 * @ProjectName:JAVA-Senior-Demo
 * @author:soldier
 * @Email:583403411@qq.com
 * @create:20-1-6上午10:02
 * @Describe:更新文档
 **/
public class UpdateDocument {

    public static void main(String[] args) {
        //  {}---->Document：一个document对象对应MongoDB中的一个{}
//        updateSingleDocumentSingleKey();

//        updateSingleDocumentManyKey();

//        updateManyDocumentSingleKey();

//        updateManyDocumentManyKey();

        updateDocumentArray();

    }

    /**
     * 更新单个文档的单个键
     */
    public static void updateSingleDocumentSingleKey() {
        //  获取集合
        MongoCollection collection = MongoDBAuthPoolUtil.getCollection("develop", "devcolltest");
        //  更新文档    Filters封装了MongoDB的条件
        //更新lisi的年龄为28 == db.devcolltest.update({username: "lisi"}, {$set: {userage: 28}})
        collection.updateOne(Filters.eq("username", "lisi"), new Document("$set", new Document("userage", 28)));
    }

    /**
     * 更新单个文档的多个键
     */
    public static void updateSingleDocumentManyKey() {
        MongoCollection collection = MongoDBAuthPoolUtil.getCollection("develop", "devcolltest");

        //更新zhangsan0的年龄为18、描述为very ok == db.devcolltest.update({username: "lisi"}, {$set: {userage: 18}, {userdesc: "Very Ok!!"}})
        collection.updateOne(Filters.eq("username", "zhangsan0"), new Document("$set",
                new Document("userage", 18).append("userdesc", "Very Ok!!")));
    }

    /**
     * 更新多个文档的单个键
     */
    public static void updateManyDocumentSingleKey() {
        MongoCollection collection = MongoDBAuthPoolUtil.getCollection("develop", "devcolltest");

        //更新用户名不为空的描述为VeryGood
        collection.updateMany(Filters.ne("username", null), new Document("$set", new Document("userdesc", "Very Good!")));
    }

    /**
     * 更新多个文档的多个键
     */
    public static void updateManyDocumentManyKey() {
        MongoCollection collection = MongoDBAuthPoolUtil.getCollection("develop", "devcolltest");

        //更新用户名不为空的年龄为20、描述为VeryGood
        collection.updateMany(Filters.ne("username", null), new Document("$set",
                new Document("userage", 20).append("userdesc", "OK")));
    }

    /**
     * 更新文档中的数组
     */
    public static void updateDocumentArray() {
        MongoCollection collection = MongoDBAuthPoolUtil.getCollection("develop", "devcolltest");

        //添加lisi的爱好 == db.devcolltest.update({username: {$eq: "lisi"}}, {$push: {userlike: "Art"}})
        collection.updateOne(Filters.eq("username", "lisi"), new Document("$push", new Document("userlike", "Art")));
    }
}
