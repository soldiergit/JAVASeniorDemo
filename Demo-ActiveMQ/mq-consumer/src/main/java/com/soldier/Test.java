package com.soldier;

/**
 * @ProjectName:Demo-ActiveMQ
 * @author:soldier
 * @Email:583403411@qq.com
 * @create:19-12-26上午9:18
 * @Describe:
 **/
public class Test {

    public static void main(String[] args) {
//        Consumer_1_HelloWorld consumer = new Consumer_1_HelloWorld();
//        consumer.readHelloWorldActiveMQ();

//        Consumer_2_User userConsumer = new Consumer_2_User();
//        userConsumer.readUserActiveMQ();

//        Consumer_3_QSListening consumer3QSListening = new Consumer_3_QSListening();
//        consumer3QSListening.readQSListeningActiveMQ();

        Consumer_4_1_Topic topic1 = new Consumer_4_1_Topic();
        Thread t1 = new Thread(topic1);
        t1.start();

        Consumer_4_2_Topic topic2 = new Consumer_4_2_Topic();
        Thread t2 = new Thread(topic2);
        t2.start();

        Consumer_4_3_Topic topic3 = new Consumer_4_3_Topic();
        Thread t3 = new Thread(topic3);
        t3.start();
    }
}
