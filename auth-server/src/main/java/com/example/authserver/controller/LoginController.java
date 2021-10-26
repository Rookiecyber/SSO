package com.example.authserver.controller;

import com.example.authserver.entity.User;
import com.example.authserver.entity.UserServiceImpl;
import com.example.authserver.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class LoginController {
    @Autowired
    UserServiceImpl userService;
    @PostMapping("login")
    @ResponseBody
    public  Map<String,Object> login(String username,String password){
        Map<String,Object> map = new HashMap<>();
        User user = new User(username,password);

        if(userService.login(user)){
            String token = JwtUtil.sign(user);
            if(token != null){
                map.put("code", "10000");
                map.put("message", "认证成功");
                map.put("token", token);
                return map;
            }
        }
        map.put("code", "0000");
        map.put("message", "认证失败");
        return map;
    }
    @PostMapping(value="/getList")
    public List<User> getList(){

        List userList = userService.getList();
        return userList;

    }
}


