package com.jt.manage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.manage.dao.UserDao;
import com.jt.manage.pojo.User;
import com.jt.manage.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	public List<User> findAll() {
		List<User> users = userDao.findAll();
		return users;
	}

	
	
	
}
