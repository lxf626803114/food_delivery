package com.mall.food.intercepter;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 拦截器，登录检查
 */
public class LoginIntercepter implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String aName = (String) session.getAttribute("aName");
        if (aName!=null){
            return true;

        }else {
            request.setAttribute("msg","请先登录");
            request.getRequestDispatcher("/").forward(request, response);
            return false;
        }
    }

}
