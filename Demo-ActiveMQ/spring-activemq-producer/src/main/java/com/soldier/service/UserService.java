package com.soldier.service;

import com.soldier.pojo.Users;

/**
 * @ProjectName:Demo-ActiveMQ
 * @author:soldier
 * @Email:583403411@qq.com
 * @create:19-12-28下午9:06
 * @Describe:实现用户对象消息的发送
 **/
public interface UserService {

    void addUser(Users users);
}
