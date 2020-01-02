package com.soldier.test;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @ProjectName:JAVA-Senior-Demo
 * @author:soldier
 * @Email:583403411@qq.com
 * @create:20-1-2下午3:56
 * @Describe:
 **/
public class HttpClientTest {

    public static void main(String[] args) throws Exception {
//        HttpClientTest.doGet();

        HttpClientTest.doGetParam();
    }

    /**
     * 发送 Get请求不带参数
     */
    public static void doGet() throws Exception {

        //  创建一个HttpClient对象
        CloseableHttpClient client = HttpClients.createDefault();
        //  创建get请求对象，在请求中输入uri
        HttpGet get = new HttpGet("http://www.baidu.com");
        //  发送请求，并返回响应
        CloseableHttpResponse response = client.execute(get);
        //处理响应
        //  获取响应状态码
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println(statusCode);
        //  获取响应内容
        HttpEntity responseEntity = response.getEntity();
        String content = EntityUtils.toString(responseEntity, "utf-8");
        System.out.println(content);
        //  关闭连接
        client.close();
    }

    /**
     * 发送 Get请求带参数
     */
    public static void doGetParam() throws Exception {
        CloseableHttpClient client = HttpClients.createDefault();
        //  创建一个封装URI的对象，在该对象中可以给定请求参数
        URIBuilder builder = new URIBuilder("https://www.sogou.com/web");
        builder.addParameter("query", "西游记");

        //  创建get请求对象
        HttpGet get = new HttpGet(builder.build());
        //  发送请求，并返回响应
        CloseableHttpResponse response = client.execute(get);
        //处理响应
        //  获取响应状态码
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println(statusCode);
        //  获取响应内容
        HttpEntity responseEntity = response.getEntity();
        String content = EntityUtils.toString(responseEntity, "utf-8");
        System.out.println(content);
        //  关闭连接
        client.close();
    }
}
