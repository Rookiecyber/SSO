package cn.edu.cqu.authserver.controller;

import cn.edu.cqu.authserver.entity.User;
import cn.edu.cqu.authserver.util.JwtUtil;
import cn.edu.cqu.authserver.entity.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RequestMapping(value = "auth")
@Controller
public class LoginController {
    @Autowired
    UserServiceImpl userService;
    @RequestMapping("index")
    public String index(){
        return "select";
    }
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    @RequestMapping("/dologin")
    public String login(String username, String password, Model model,
                        HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        Map<String,Object> map = new HashMap<>();
        User user = new User(username,password);
        if(userService.login(user)){
            String token = JwtUtil.sign(user);
            if(token != null){
                map.put("code", "10000");
                map.put("message", "认证成功");
                map.put("token", token);
                model.addAttribute("message",map);
                //创建cookie实例。 
//                HttpCookie cookie = new HttpCookie("token",token);
                Cookie ck = new Cookie("token",token);
                ck.setPath("/"); //将ck设置在全局
                httpServletResponse.addCookie(ck);
                return "select";
            }
        }
        map.put("code", "0000");
        map.put("message", "认证失败");
        model.addAttribute("message",map);
        return "error";
    }
    @RequestMapping("/logout")
    public String logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        Cookie[] cookies= httpServletRequest.getCookies();
        for(Cookie cookie :cookies){
            if(cookie.getName().equals("token")){
                //设置ck的过期时间为0并且清空token
                cookie =new Cookie("token",null);
                cookie.setPath("/");
                cookie.setMaxAge(0);
                httpServletResponse.addCookie(cookie);
//                System.out.println("ck的过期时间为"+cookie.getMaxAge());
            }
        }

        return "login";
    }
}

