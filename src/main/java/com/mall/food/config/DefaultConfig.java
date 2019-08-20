package com.mall.food.config;


import com.mall.food.intercepter.LoginIntercepter;
import org.springframework.context.annotation.Configuration;


import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;




@Configuration
public class DefaultConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
//        先经过controller层的处理器,在经过下面的
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/top.html").setViewName("top");
        registry.addViewController("/main.html").setViewName("main");
        registry.addViewController("/menu.html").setViewName("menu");
        registry.addViewController("/bar.html").setViewName("bar");
        registry.addViewController("/ma.html").setViewName("index");
        registry.addViewController("/register.html").setViewName("register");

    }

    // 将拦截器注册到拦截器队列中
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截其他界面
        registry.addInterceptor(new LoginIntercepter())
                .addPathPatterns("/**")
                .excludePathPatterns("/passwordTest","/tel","/static/**","/","/login","/login.html","/register","/register.html");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
}