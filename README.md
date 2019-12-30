# JAVA高级技术学习笔记

### ActiveMQ学习笔记
#### 运行项目
1. 启动ActiveMQ
```cfml
su
/usr/local/activemq/bin/activemq start
```
2. 启动消费者
```cfml
# 启动spring-activemq-consumer下的test下的TestActiveMQ的main方法
```
##
 
### JsonP学习笔记
#### 需求
```text
1）创建两个 web 工程，名称为 jsonDemo1(8080)、jsonDemo2(9090)
2）jsonDemo1 中提供一个 index.jsp。
3）在 jsonDemo1 的 index.jsp 中通过 Jquery 的 Ajax 跨域请求 jsonDemo2
```
![Image text](https://raw.githubusercontent.com/soldiergit/JAVA-Senior-Demo/master/images/jsonP1.png)
```text
4）jsonDemo2 中使用 springMVC 处理请求，返回一个 json 对象
5）在 jsonDemo1 中将返回的结果插入到 index.jsp 中
```