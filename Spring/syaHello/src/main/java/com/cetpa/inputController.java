
package com.cetpa;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class inputController {

    @GetMapping("/input")
    public String sayHello() {
        
        return "input-form.jsp";
    }

    @GetMapping("/sayHello")
    public String sayHelloToUser(String name, Model model) {
        
    	model.addAttribute("msg", "Hello " +name);
        return "output.jsp";
    }
}
