package com.cetpa;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/demo")
public class HelloController {

    @GetMapping("/hello")
    public String getInputForm() {
        return "hello-form"; 
    }

    @GetMapping("/sayhello")
    public ModelAndView sayHelloToUser(@RequestParam("str") String str) {
        ModelAndView modelAndView = new ModelAndView("sayhello"); 
        modelAndView.addObject("name", str);
        return modelAndView;
    }
}
