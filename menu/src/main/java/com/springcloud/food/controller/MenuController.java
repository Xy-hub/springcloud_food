package com.springcloud.food.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/index")
    public String index(){
        return this.port;
    }
}
