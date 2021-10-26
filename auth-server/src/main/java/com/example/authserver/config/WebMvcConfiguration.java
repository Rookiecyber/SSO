package com.example.authserver.config;


import com.example.authserver.interceptor.AuthInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(authInterceptor())
                .addPathPatterns("/auth/**") // 拦截所有请求，
                .excludePathPatterns("/auth/login");
    }

    @Bean
    public AuthInterceptor authInterceptor(){
        return  new AuthInterceptor();
    }
}
