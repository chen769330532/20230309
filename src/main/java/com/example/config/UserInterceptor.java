package com.example.config;

import com.example.interceptor.MyHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Chenjl
 * @date 2020/8/18 16:13
 */
@Configuration
public class UserInterceptor extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加拦截器
        registry.addInterceptor(new MyHandlerInterceptor())
                //拦截所有请求
                .addPathPatterns("/mysql/**/")
                //对应的不拦截的请求
                .excludePathPatterns("/mysql/emp");
    }
}
