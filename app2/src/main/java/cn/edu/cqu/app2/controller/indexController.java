package cn.edu.cqu.app2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/app2")
public class indexController {
    //    @PostMapping("/index")
    @RequestMapping("/index")
    public  String index(HttpServletRequest request, Model model){
        /*读取ck*/
        String token = "";
        Cookie[] cookies = request.getCookies();
        Cookie cookie = null;
        for (int j = 0; j < cookies.length; j++) {
            cookie = cookies[j];
            if (cookie.getName().equals("token")) {
                token = cookie.getValue();
                model.addAttribute("token",token);
                return  "index";
            }
        }
        return "redirect:http://127.0.0.1:8080/auth/login";
    }
}
