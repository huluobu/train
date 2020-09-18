package com.carrot.train.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class clientAnnotationController {
    @RequestMapping(value = "/client",method = {RequestMethod.GET})
    public String client(Model mode) {
        mode.addAttribute("value", "value is client");
        return "client";
    }
}
