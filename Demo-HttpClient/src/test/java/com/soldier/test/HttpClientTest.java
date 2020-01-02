package com.soldier.test;

import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

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

//        HttpClientTest.doGetParam();

//        HttpClientTest.doPost();

//        HttpClientTest.doPostParam();

        HttpClientTest.doPostParamJson();
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

    /**
     * 发送 POST 请求不带参数
     */
    public static void doPost() throws Exception {
        CloseableHttpClient client = HttpClients.createDefault();
        //  创建post请求对象，在请求中输入uri
        HttpPost post = new HttpPost("http://localhost:8080/test/post");
        //  发送请求，并返回响应
        CloseableHttpResponse response = client.execute(post);
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
     * 发送 POST 请求带参数
     */
    public static void doPostParam() throws Exception {
        CloseableHttpClient client = HttpClients.createDefault();
        //  创建post请求对象，在请求中输入uri
        HttpPost post = new HttpPost("http://localhost:8080/test/post/param");
        //  给定参数:与get不同,这里需要给定参数,需要用list来封装多个参数
        List<BasicNameValuePair> list = new ArrayList<BasicNameValuePair>();
        list.add(new BasicNameValuePair("username", "张三丰"));
        list.add(new BasicNameValuePair("password", "zhangsanfeng"));
        //  将参数作字符串转换:转换参数,并设置参数编码
        StringEntity entity = new UrlEncodedFormEntity(list, "utf-8");
        //  向请求中绑定参数
        post.setEntity(entity);

        //  发送请求，并返回响应
        CloseableHttpResponse response = client.execute(post);
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
     * 发送 POST 请求带JSON格式参数
     */
    public static void doPostParamJson() throws Exception {
        CloseableHttpClient client = HttpClients.createDefault();
        //  创建post请求对象，在请求中输入uri
        HttpPost post = new HttpPost("http://localhost:8080/test/post/param/json");
        //  创建json数据
        String json = "{\"password\":\"zhangsanfeng\",\"username\":\"张三丰\"}";
        //  设置entity为json格式
        StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
        //  向请求中绑定参数
        post.setEntity(entity);

        //  发送请求，并返回响应
        CloseableHttpResponse response = client.execute(post);
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
