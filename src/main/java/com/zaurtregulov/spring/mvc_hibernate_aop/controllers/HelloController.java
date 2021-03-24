package com.zaurtregulov.spring.mvc_hibernate_aop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class HelloController {
    @GetMapping("/hello-world")
    public String sayHello(){
        return "hello_world";
    }
}
