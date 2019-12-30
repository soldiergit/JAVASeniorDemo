package com.soldier;

/**
 * @ProjectName:Demo-ActiveMQ
 * @author:soldier
 * @Email:583403411@qq.com
 * @create:19-12-26上午9:09
 * @Describe:
 **/
public class Test {

    public static void main(String[] args) {

//        Producer_1_HelloWorld producer = new Producer_1_HelloWorld();
//        producer.sendHelloWorldActiveMQ("HelloWorld");

//        User user = new User();
//        user.setUserName("soldier");
//        user.setAge(20);
//        Producer_2_User userProducer = new Producer_2_User();
//        userProducer.sendUserActiveMQ(user);

//        Producer_3_QSListening producer3QSListening = new Producer_3_QSListening();
//        producer3QSListening.sendQSListeningActiveMQ("队列服务监听-admin");

        Producer_4_Topic topicProducer = new Producer_4_Topic();
        topicProducer.sendTopicActiveMQ("Hello Topic");
    }
}
