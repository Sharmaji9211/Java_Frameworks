package com.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo")
public class DemoController 
{
	@GetMapping("/add")
	public String addUser()
	{
		return "User has been added";
	}
	@GetMapping("/update")
	public String updateUser()
	{
		return "User has been updated";
	}
	@GetMapping("/delete")
	public String deleteUser()
	{
		return "User has been deleted";
	}
	@GetMapping("/list")
	public String getUserList()
	{
		return "User list has been forwarded";
	}
}
