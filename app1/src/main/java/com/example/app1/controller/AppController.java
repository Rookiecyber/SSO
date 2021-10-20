package com.example.app1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/app1")
public class AppController {
    @RequestMapping(value = "/index")
    public String index(){
        return "index";
    }
}
