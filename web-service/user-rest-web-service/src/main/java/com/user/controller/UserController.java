package com.user.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.user.model.User;
import com.user.service.UserService;

@Controller
@ResponseBody
public class UserController 
{
	private final UserService userService;
	public UserController(UserService userService) 
	{
		this.userService = userService;
	}
	//API to create resource(insert data)
	@PostMapping("/add")//users/add
	public User addUser(@RequestBody User user)
	{
		userService.saveUser(user);
		return user;
	}
	//API to get all resources(select all data)
	@GetMapping
	public List<User> getUsers()
	{
		List<User> userList=userService.getUserList();
		return userList;
	}
	//API to get a resources yb id(select specific data)
	@GetMapping("/{uid}")//users/101
	public User getUser(@PathVariable int uid)
	{
		User user=userService.getUserById(uid);
		return user;
	}
	@PutMapping("update/{uid}")
	public User updateUser(@PathVariable int uid,@RequestBody User user)
	{
		User existingUser=userService.getUserById(uid);
		if(existingUser!=null)
		{
			user.setId(uid);
			userService.updateUser(user);
			return user;
		}
		userService.saveUser(user);
		return user;
	}
}
