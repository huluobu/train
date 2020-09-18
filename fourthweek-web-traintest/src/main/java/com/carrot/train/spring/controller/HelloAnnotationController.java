package com.carrot.train.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloAnnotationController {
    @RequestMapping(value = {"/hello"}, method = {RequestMethod.GET})
    public String hello2(Model model) {
        model.addAttribute("message", "您好，世界...");
        return "hello";
    }

}
