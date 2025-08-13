package com.user.service;

import java.util.List;

import com.user.model.User;

public interface UserService 
{
	void saveUser(User user);
	List<User> getUserList();
	User getUserById(int uid);
	void updateUser(User user);
}
