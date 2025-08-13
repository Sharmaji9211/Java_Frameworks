package com.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.user.dao.UserDao;
import com.user.model.User;

@Service
public class UserServiceImpl implements UserService 
{
	private final UserDao userDao;
	public UserServiceImpl(UserDao userDao) 
	{
		this.userDao = userDao;
	}
	public void saveUser(User user) 
	{
		userDao.save(user);
	}
	public List<User> getUserList() 
	{
		return userDao.findAll();
	}
	public User getUserById(int uid) 
	{
		return userDao.findById(uid).orElse(null);
	}
	public void updateUser(User user) 
	{
		userDao.save(user);
	}
}
