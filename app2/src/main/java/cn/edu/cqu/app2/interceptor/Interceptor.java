package cn.edu.cqu.app2.interceptor;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.servlet.HandlerInterceptor;
import cn.edu.cqu.authserver.util.JwtUtil;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Interceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        /*读取ck*/
        String token = "";
        Cookie[] cookies = request.getCookies();
        Cookie cookie = null;
        for (int j = 0; j < cookies.length; j++) {
            cookie = cookies[j];
            if (cookie.getName().equals("token")) {
                token = cookie.getValue();
            }
        }
        System.out.println("token是"+token);
        if(token != null){
            if(JwtUtil.verify(token)){
                return true;
            }
        }
        response.sendRedirect("http://127.0.0.1:8080/auth/login"); //重定向到登录页面
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        System.out.println(request.getServletPath());
        try{
            JSONObject json = new JSONObject();
            json.put("success","false");
            json.put("msg","认证失败，未通过拦截器");
            json.put("code","50000");
            response.getWriter().append(json.toJSONString());
            System.out.println("认证失败，未通过拦截器");
        }catch (Exception e){
            e.printStackTrace();
            response.sendError(500);
            return false;
        }
        return false;
    }
}
