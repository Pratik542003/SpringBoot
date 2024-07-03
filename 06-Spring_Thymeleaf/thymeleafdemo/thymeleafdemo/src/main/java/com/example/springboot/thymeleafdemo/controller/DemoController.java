package com.example.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
//    "cREATE MAPPING FOR "/hello""
    @GetMapping("/hello")
    public String sayHello(Model theModel){
        theModel.addAttribute("theData",java.time.LocalDateTime.now());
        return "helloWorld";
    }
}
