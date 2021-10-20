package com.example.authserver.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.example.authserver.annotation.LoginRequired;
import com.example.authserver.entity.User;
import com.example.authserver.entity.UserService;
import com.example.authserver.util.CookieUtil;
import com.example.authserver.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    UserService userService;
    @PostMapping(value = "/login")
    public Object login(@RequestParam("username") String username, @RequestParam("password") String password,
                        HttpServletRequest request, HttpServletResponse response, ModelMap modelMap){
        JSONObject jsonObject=new JSONObject();
            if (!password.equals("123")){
                jsonObject.put("message","登录失败,密码错误");
                return jsonObject;
            }else {
                User user = new User(username,password);
                String token = JwtUtil.encode(user);
                jsonObject.put("token", token);
                jsonObject.put("user", username);
                return jsonObject;
            }
        }
    @LoginRequired
    @GetMapping("/getMessage")
    public String getMessage(){
        return "tongguo";
    }
}
//    private JSON JSONUtils;
//
//    @PostMapping("/login")
//    @ResponseBody
//    public String login(@RequestParam("username") String username, @RequestParam("password") String password,
//                        HttpServletRequest request, HttpServletResponse response, ModelMap modelMap){
//        Loginbean loginbean = new Loginbean();
//        loginbean.setUsername(username);
//        loginbean.setPassword(password);
//        Boolean issuccess = userService.login(loginbean);
//        if (!issuccess) {
//            return "fail";//返回一个提示
//        } else { //登录成功
//            // 根据已经登录的用户信息和，服务器密钥，和其他盐值(根据系统算法)生成一个token
//            String key = "itlinlisso";
//            //String ip = request.getRemoteAddr();
//            //String ip = request.getHeader("x-forward-for");//nginx
//            //String token = JwtUtil.encode(key, map, ip);
//            String name = loginbean.getUsername();
////            Long userId = loginbean.getUserId();
////            String id = String.valueOf(userId);
//            String token = JwtUtil.encode(name);
//            // 将生成的token和登录用户信息保存在缓存中一分
//            //userService.addUserCache(token, umsMemberFromDb);
//            CookieUtil.setCookie(request,response,"oldToken",token,30*60,true);
//            return token;
//        }
//
//    }
//    @GetMapping("verify")
//    @ResponseBody
//    public String verify(String token)  {
//        System.out.println("认证中心认证用户的token");
//        //String key = "itlinlisso";
//        //String ip = currentIp;
//        Map<String, String> map = null;//验证token是否是同一个。不是则返回null
//        Map<String, String> verifyReturn = new HashMap<>();
//        try {
//            map = JwtUtil.decode(token);
//
////            String userId = map.get("userId");
//            String username = map.get("username");
//
//            verifyReturn.put("success", "success");   //存入用户id和姓名
////            verifyReturn.put("userId", userId);
//            verifyReturn.put("username", username);
//            System.out.println(verifyReturn);
////            return JSON.toJSONString(verifyReturn);//转成json格式返回
//            return  JSONUtils.toJSONString(verifyReturn);
//        } catch (Exception e) {
//            verifyReturn.put("success", "fail");
////            return JSON.toJSONString(verifyReturn);
//            return JSONUtils.toJSONString(verifyReturn);
//        }
//
//    }
//    @RequestMapping("index")
//    public String index(String ReturnUrl, ModelMap modelMap) {
//        System.out.println("认证中心首页");
//
//        modelMap.put("ReturnUrl", ReturnUrl);
//        return "index";
//    }
//    @RequestMapping("/main")
//    @LoginRequired
//    public String main(HttpServletRequest request,ModelMap modelMap){
////        String memberId = (String) request.getAttribute("userId");
//        String nickname = (String) request.getAttribute("username");
////        modelMap.put("memberId",memberId);
//        modelMap.put("nickname",nickname);
//        return  "main";
//    }

