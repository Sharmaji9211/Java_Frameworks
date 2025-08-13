package com.cetpa;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {
    @GetMapping("/home")
    public String showForm() {
        return "home";
    }
    @PostMapping("/sayHello")
    public String greetUser(@RequestParam("username") String username, Model model) {
        model.addAttribute("message", "Hello " + username);
        return "result";
    }
}
