package com.cetpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/demo")
public class home {
	
@GetMapping("/")
public String gethello() {
	return "home"; 
}
	@GetMapping("/greeting")
	public ModelAndView sayHelloToUser(@RequestParam("str") String str) 
	{
	    ModelAndView modelAndView = new ModelAndView("greeting"); 
	    modelAndView.addObject("name", str);
	    return modelAndView;
	}
}
