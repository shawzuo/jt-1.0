package com.jt.manage.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jt.manage.mapper.UserMapper;
import com.jt.manage.pojo.User;

@Repository
public class UserDao {
	
	@Autowired
	private UserMapper userMapper;
	
	
	public List<User> findAll() {
		return userMapper.findAll();
	}

	
	
}
