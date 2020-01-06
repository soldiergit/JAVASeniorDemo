package com.soldier.document;

import com.mongodb.client.MongoCollection;
import com.soldier.MongoDBAuthPoolUtil;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ProjectName:JAVA-Senior-Demo
 * @author:soldier
 * @Email:583403411@qq.com
 * @create:20-1-6上午9:25
 * @Describe:添加文档
 **/
public class InsertDocument {

    public static void main(String[] args) {
//        insertSingleDocument();
        insertManyDocument();
    }

    /**
     * 添加单个文档
     *  当前用户必须具备写权限
     */
    public static void insertSingleDocument () {
        //  获取集合
        MongoCollection collection = MongoDBAuthPoolUtil.getCollection("develop", "devcolltest");
        //  {}---->Document
        Document document = new Document();
        document.append("username", "lisi").append("userage", 26).append("userdesc", "very good")
                .append("userlike", Arrays.asList(new String[]{"music", "sport"}));
        collection.insertOne(document);
    }

    /**
     * 添加多个文档
     *  当前用户必须具备写权限
     */
    public static void insertManyDocument () {
        //  获取集合
        MongoCollection collection = MongoDBAuthPoolUtil.getCollection("develop", "devcolltest");
        List<Document> documentList = new ArrayList<Document>();
        for (int i=0; i<5; i++) {
            Document document = new Document();
            document.append("username", "zhangsan"+i)
                    .append("userage", 20+i)
                    .append("userdesc", "very good"+i)
                    .append("userlike", Arrays.asList(new String[]{"music", "sport"}));
            documentList.add(document);
        }
        collection.insertMany(documentList);
    }
}
