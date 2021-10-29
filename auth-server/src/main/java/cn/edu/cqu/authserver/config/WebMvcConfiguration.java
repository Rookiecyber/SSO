package cn.edu.cqu.authserver.config;


import cn.edu.cqu.authserver.interceptor.AuthInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(authInterceptor())
                .addPathPatterns("/**") // 拦截所有请求，
                .addPathPatterns("auth/**")
                .excludePathPatterns("auth/index")
                .excludePathPatterns("/auth/login")
                .excludePathPatterns("/auth/dologin")
                .excludePathPatterns("auth/logout")
                .excludePathPatterns("/static/**");
    }

    @Bean
    public AuthInterceptor authInterceptor(){
        return  new AuthInterceptor();
    }
}
