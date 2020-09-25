package com.carrot.train.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Helloworld {
    private String hello = "hello world";

    @RequestMapping("/hello")
    public String helloworld() {
        System.out.println(hello);
        return "/user/login";
    }

}
