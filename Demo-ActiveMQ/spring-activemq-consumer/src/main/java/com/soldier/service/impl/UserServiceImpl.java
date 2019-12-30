package com.soldier.service.impl;

import org.springframework.stereotype.Service;

import com.soldier.pojo.Users;
import com.soldier.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public void showUser(Users user) {
		System.out.println(user.toString());
	}

}
