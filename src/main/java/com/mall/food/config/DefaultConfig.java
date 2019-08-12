package com.mall.food.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class DefaultConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
//        先经过controller层的处理器,在经过下面的
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/top.html").setViewName("top");
        registry.addViewController("/main.html").setViewName("main");
        registry.addViewController("/menu.html").setViewName("menu");
        registry.addViewController("/bar.html").setViewName("bar");

    }
//    //日期格式化有错
//    @Override
//    public void addFormatters(FormatterRegistry registry) {
//        registry.addFormatter(new DateFormatter("yyyy-MM-dd HH:mm:ss"));
//    }

//    //注册自定义的区域解析器
//    @Bean
//    public LocaleResolver localeResolver() {
//        return  new MyLocaleResolver();
//    }
//
//    // 由于区域解析器不灵敏,使用定义一个区域改变的拦截器  并注册到spring 容器中,保证注册
//    @Bean
//    public LocaleChangeInterceptor localeChangeInterceptor(){
//        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
//        localeChangeInterceptor.setParamName("l");
//        return localeChangeInterceptor;
//    }
//
//
//    // 将拦截器注册到拦截器队列中
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(localeChangeInterceptor());
//        //拦截其他界面
//        registry.addInterceptor(new LoginIntercepter())
//                .addPathPatterns("/**")
//                .excludePathPatterns("/static/**","/index.html","/","/login","/hello");
//    }
//
////自定义的区域解析器
//    protected class MyLocaleResolver implements LocaleResolver {
//
//        @Override
//        public Locale resolveLocale(HttpServletRequest httpServletRequest) {
//            String l = httpServletRequest.getParameter("l");
//            Locale locale = Locale.getDefault();
//            if (!StringUtils.isEmpty(l)) {
//                String[] split = l.split("_");
//                locale = new Locale(split[0], split[1]);
//            }
//            return locale;
//        }
//
//        @Override
//        public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {
//
//        }
//    }
}