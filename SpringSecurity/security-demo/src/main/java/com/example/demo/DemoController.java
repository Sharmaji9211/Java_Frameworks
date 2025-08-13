package com.example.demo;

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
}
