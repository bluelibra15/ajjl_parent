package com.ajjl.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String sayHello(
            @RequestParam(name = "name",defaultValue = "default") String name){
        return "hello "+ name;
    }
}
