package com.soldier.document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.soldier.MongoDBAuthPoolUtil;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.regex.Pattern;

/**
 * @ProjectName:JAVA-Senior-Demo
 * @author:soldier
 * @Email:583403411@qq.com
 * @create:20-1-6上午11:16
 * @Describe:查询文档
 **/
public class SelectDocument {

    public static void main(String[] args) {

//        selectDocumentAll();

//        selectDocumentById();

//        selectDocumentConditionByGT();

//        selectDocumentConditionByTYPE();

//        selectDocumentConditionByIN();

//        selectDocumentConditionByNin();

//        selectDocumentConditionByRegex();

//        selectDocumentConditionByAnd();

//        selectDocumentConditionByOr();

//        selectDocumentConditionByAndOr();

        selectDocumentSorting();
    }

    /**
     * 查询全部文档
     */
    public static void selectDocumentAll() {
        MongoCollection collection = MongoDBAuthPoolUtil.getCollection("develop", "devcolltest");

        //  返回一个文档迭代器
        FindIterable<Document> findIterable = collection.find();
        printDocument(findIterable);
    }

    /**
     * 根据id查询文档
     */
    public static void selectDocumentById() {
        MongoCollection collection = MongoDBAuthPoolUtil.getCollection("develop", "devcolltest");

        //  返回一个文档迭代器
        FindIterable<Document> findIterable = collection.find(Filters.eq("_id", new ObjectId("5e12933036c3300c12169b5c")));
        printDocument(findIterable);
    }

    /**
     * 查询多个文档-$gt(大于，条件查询)；lt(小于操作符 )、gte(大于或等于)、lte(小于或等于)、eq(等于)、ne(不等)均类似
     */
    public static void selectDocumentConditionByGT() {
        MongoCollection collection = MongoDBAuthPoolUtil.getCollection("develop", "devcolltest");

        //  返回一个文档迭代器：查询年龄大于19的
        FindIterable<Document> findIterable = collection.find(Filters.gt("userage", 19));
        printDocument(findIterable);
    }

    /**
     * 查询多个文档-$type(数据类型，条件查询)
     */
    public static void selectDocumentConditionByTYPE() {
        MongoCollection collection = MongoDBAuthPoolUtil.getCollection("develop", "devcolltest");

        //  返回一个文档迭代器：查询年龄是number类型的
        FindIterable<Document> findIterable = collection.find(Filters.type("userage", "number"));
        printDocument(findIterable);
    }

    /**
     * 查询多个文档-$in(与mysql中的in一样，正则查询)
     */
    public static void selectDocumentConditionByIN() {
        MongoCollection collection = MongoDBAuthPoolUtil.getCollection("develop", "devcolltest");

        //  返回一个文档迭代器：查询用户名为zhangsan1，zhangsan2
        FindIterable<Document> findIterable = collection.find(Filters.in("username", "zhangsan1", "zhangsan2"));
        printDocument(findIterable);
    }

    /**
     * 查询多个文档-$nin(与mysql中的not in一样，正则查询)
     */
    public static void selectDocumentConditionByNin() {
        MongoCollection collection = MongoDBAuthPoolUtil.getCollection("develop", "devcolltest");

        //  返回一个文档迭代器：查询用户名不是zhangsan1，zhangsan2
        FindIterable<Document> findIterable = collection.find(Filters.nin("username", "zhangsan1", "zhangsan2"));
        printDocument(findIterable);
    }

    /**
     * 查询多个文档-$regex(与mysql中配合上%的like一样，正则查询)
     */
    public static void selectDocumentConditionByRegex() {
        MongoCollection collection = MongoDBAuthPoolUtil.getCollection("develop", "devcolltest");

        //  返回一个文档迭代器：查询用户名以z开通2结尾的
        FindIterable<Document> findIterable = collection.find(Filters.regex("username", Pattern.compile("^z.*2$")));
        printDocument(findIterable);
    }

    /**
     * 查询多个文档-$and(与mysql中的and一样，多条件查询 逻辑运算符)
     */
    public static void selectDocumentConditionByAnd() {
        MongoCollection collection = MongoDBAuthPoolUtil.getCollection("develop", "devcolltest");

        //  返回一个文档迭代器：查询用户名为zhangsan1且年龄为20
        FindIterable<Document> findIterable = collection.find(
                Filters.and(
                        Filters.eq("username", "zhangsan1"),
                        Filters.eq("userage", 20)
                )
        );
        printDocument(findIterable);
    }

    /**
     * 查询多个文档-$or(与mysql中的or一样，多条件查询 逻辑运算符)
     */
    public static void selectDocumentConditionByOr() {
        MongoCollection collection = MongoDBAuthPoolUtil.getCollection("develop", "devcolltest");

        //  返回一个文档迭代器：查询用户名为lisi 或者年龄为20 或者userdesc为OK
        FindIterable<Document> findIterable = collection.find(
                Filters.or(
                        Filters.eq("username", "lisi"),
                        Filters.eq("userage", 20),
                        Filters.eq("userdesc", "OK")
                )
        );
        printDocument(findIterable);
    }

    /**
     * 查询多个文档-$and与$or联合使用(与mysql中的and与or联合一样，多条件查询 逻辑运算符)
     */
    public static void selectDocumentConditionByAndOr() {
        MongoCollection collection = MongoDBAuthPoolUtil.getCollection("develop", "devcolltest");

        //  返回一个文档迭代器：查询用户名为lisi且年龄为20，或者userdesc为OK
        FindIterable<Document> findIterable = collection.find(
                Filters.or(
                        Filters.and(
                                Filters.eq("username", "lisi"),
                                Filters.eq("userage", 20)
                        ),
                        Filters.eq("userdesc", "OK")
                )
        );
        printDocument(findIterable);
    }

    /**
     * 查询多个文档-$and与$or联合使用(与mysql中的ASC(1：升序)、DSC(:1：降序)一样，多条件查询 逻辑运算符)
     */
    public static void selectDocumentSorting() {
        MongoCollection collection = MongoDBAuthPoolUtil.getCollection("develop", "devcolltest");

        //  返回一个文档迭代器：查询用户名以z开头，根据用户名对结果做降序
        FindIterable<Document> findIterable = collection.find(
                Filters.regex("username", Pattern.compile("^z"))
        ).sort(new Document("username", -1));
        printDocument(findIterable);
    }

    /**
     * 输出文档内容
     */
    public static void printDocument(FindIterable<Document> findIterable) {
        //  获取所有文档的游标，类似于mysql的ResultSet
        MongoCursor<Document> cursor = findIterable.iterator();

        while (cursor.hasNext()) {
            Document document = cursor.next();
            System.out.println(document.get("username") + "\t" + document.get("userage") + "\t"
                    +document.get("userdesc") + "\t" +document.get("userlike"));
        }
    }
}
