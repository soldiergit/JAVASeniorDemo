package com.soldier;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @ProjectName:Demo-ActiveMQ
 * @author:soldier
 * @Email:583403411@qq.com
 * @create:19-12-25下午8:51
 * @Describe:实现文本传递-提供者
 **/
public class Producer_4_Topic {

    /**
     * 生产消息
     */
    public void sendTopicActiveMQ(String msgTest) {

        //  定义链接工厂
        ConnectionFactory connectionFactory = null;

        //  定义链接
        Connection connection = null;

        //  定义会话
        Session session = null;

        //  目的地
        Destination destination = null;

        //  定义消息的发送者
        MessageProducer producer = null;

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
            destination = session.createTopic("test-topic");

            //  创建消息的生产者
            producer = session.createProducer(destination);

            //  创建消息
            message = session.createTextMessage(msgTest);

            //  发送消息
            producer.send(message);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //  关闭:顺序不能变
            try {
                if (producer != null) producer.close();
                if (session != null) session.close();
                if (connection != null) connection.close();
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
