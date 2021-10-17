package com.example.sso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class indexController {
    @RequestMapping(value = "/select")
    public String index2(){
        return "select";
    }
    @RequestMapping(value = "/indexA")
    public String index1(){
        return "indexA";
    }
    @RequestMapping(value = "/indexB")
    public String index(){
        return "indexB";
    }
//    @RequestMapping(value = "/login")
//    public String login(){
//        return "index1";
//    }
}
