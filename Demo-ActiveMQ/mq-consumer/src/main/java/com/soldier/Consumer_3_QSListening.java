package com.soldier;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @ProjectName:Demo-ActiveMQ
 * @author:soldier
 * @Email:583403411@qq.com
 * @create:19-12-26上午8:59
 * @Describe:实现文本传递-消费者
 **/
public class Consumer_3_QSListening {

    /**
     * 消费消息
     */
    public void readQSListeningActiveMQ() {

        //  定义链接工厂
        ConnectionFactory connectionFactory = null;

        //  定义链接
        Connection connection = null;

        //  定义会话
        Session session = null;

        //  目的地
        Destination destination = null;

        //  定义消息的消费者
        MessageConsumer consumer = null;

        //  定义消息
        Message message = null;

        try {
            /**
             * userName：访问ActiveMQ服务的用户名（和密码默认为admin），用户名可以通过jetty-ream.properties文件修改
             * password：访问ActiveMQ服务的密码（和用户名默认为admin），用户名可以通过jetty-ream.properties文件修改
             * brokerURL：访问ActiveMQ服务的路径地址，格式为： 协议名://主机地址:端口号
             */
            connectionFactory = new ActiveMQConnectionFactory("admin", "admin", "tcp://localhost:61616");

            //  创建链接
            connection = connectionFactory.createConnection();

            //  启动链接
            connection.start();

            /**
             * transacted：表示是否使用事务  true|false
             *              true：使用事务，acknowledgeMode可以设置为：Session.SESSION_TRANSACTED
             *              false：不使用事务，acknowledgeMode参数必须设置
             * acknowledgeMode：消息确认机制
             *      Session.AUTO_ACKNOWLEDGE    ：自动消息确认机制
             *      Session.CLIENT_ACKNOWLEDGE  ：客户端消息确认机制
             *      Session.DUPS_OK_ACKNOWLEDGE ：有副本的客户端消息确认机制
             */
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            //  创建目的地，目的地名称即：队列名称消息的消费者需要此名称访问对应的队列
            destination = session.createQueue("my-destination");

            //  创建消息的消费者
            consumer = session.createConsumer(destination);

           consumer.setMessageListener(new MessageListener() {
               //   ActiveMQ回调的方法：将消息传递到consumer中
               public void onMessage(Message message) {
                   //   处理消息
                    String msg = null;
                    try {
                        msg = ((TextMessage) message).getText();
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                   System.out.println("从ActiveMQ中获取的消息："+msg);
               }
           });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
