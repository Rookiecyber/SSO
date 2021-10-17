package com.example.sso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class loginController {
    /*
    登录页面
    * */
    @RequestMapping(value = "/login")
    public String login(Model model){
        model.addAttribute("data1","第一个数据");
        model.addAttribute("data2","第二个数据");
        return "login";
    }
    /*
    登录验证， POST
    **/
    @RequestMapping(value = "/dologin",method = RequestMethod.POST)
    public String dolgoin(@RequestParam(name = "username")String username,
                          @RequestParam(name="password")String password,Model model)
    {
        if (username.equals("admin") && password.equals("123")) {
            model.addAttribute("message","登录成功");
            return "select";
        } else {
            model.addAttribute("message","账号或密码输入错误！");
            return "error";
        }
    }
}
