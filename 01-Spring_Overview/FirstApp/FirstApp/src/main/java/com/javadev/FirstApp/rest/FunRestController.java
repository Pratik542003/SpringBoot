package com.javadev.FirstApp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    // expose " / " that return "HelloWorld"
    @GetMapping("/")
    public String sayHello(){
        return "Hello World";
    }
}
