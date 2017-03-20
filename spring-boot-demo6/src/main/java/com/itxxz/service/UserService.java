package com.itxxz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itxxz.entity.User;
import com.itxxz.mapper.UserMapper;

@Service
public class UserService {

	@Autowired
	UserMapper userMapper;
	
	public User findUserByAccount(String account){
		return userMapper.findUserByAccount(account);
	}
}
