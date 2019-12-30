package com.soldier.service.impl;

import com.soldier.pojo.Users;
import com.soldier.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * @ProjectName:Demo-ActiveMQ
 * @author:soldier
 * @Email:583403411@qq.com
 * @create:19-12-28下午9:07
 * @Describe:实现用户对象消息的发送
 **/
@Service
public class UserServiceImpl implements UserService {

    //  注入JmsTemplate对象
    @Autowired
    private JmsTemplate jmsTemplate;

    public void addUser(final Users users) {
        //  发送消息
        this.jmsTemplate.send(new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(users);
            }
        });
    }
}
