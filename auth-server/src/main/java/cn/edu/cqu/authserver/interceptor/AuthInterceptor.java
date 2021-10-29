package cn.edu.cqu.authserver.interceptor;

import cn.edu.cqu.authserver.util.JwtUtil;
import org.springframework.web.servlet.HandlerInterceptor;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        if(request.getMethod().equals("OPTIONS")){
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }

        response.setCharacterEncoding("utf-8");
        /*读取ck*/
        String admissionNo = "";
        Cookie[] cookies = request.getCookies();
        Cookie cookie = null;
        for (int j = 0; j < cookies.length; j++) {
            cookie = cookies[j];
//            System.out.println(cookie.getName());
//            System.out.println(cookie.getValue());
            if (cookie.getName().equals("token")) {
                admissionNo = cookie.getValue();
            }
        }
        System.out.println("token是"+admissionNo);
//        System.out.println("cookies为"+cks);
//        System.out.println(request.getRequestURI()) ;
//        String token = request.getHeader("admin-token");
        //从ck中读出token然后进行验证
        String token = admissionNo;
        if(token != null){
            boolean result = JwtUtil.verify(token);
            if(result){
                System.out.println("token:"+token);
                System.out.println("通过拦截器");
                return true;
            }
        }
        response.sendRedirect("/auth/login");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;
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

