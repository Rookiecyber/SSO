package cn.edu.cqu.app2.config;

import cn.edu.cqu.app2.interceptor.Interceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class webconfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(appInterceptor())
                .addPathPatterns("/**") // 拦截所有请求，
                .excludePathPatterns("app2/index")
                .excludePathPatterns("/static/**");
    }

    @Bean
    public Interceptor appInterceptor(){
        return  new Interceptor();
    }
}

