package com.mall.food.controller;

import com.mall.food.mapper.AdministratorMapper;
import com.mall.food.pojo.Administrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private AdministratorMapper administratorMapper;
    @RequestMapping("/login")
    public String login(String aName, String password, HttpSession session, Map<String,Object> map){
        Administrator administrator = administratorMapper.selectByAname(aName);
        if(administrator!=null){
            if(password.equals(administrator.getPassword())){
                session.setAttribute("aName",aName);
                return "redirect:ma.html";
            }
            map.put("msg","密码错误");
            return "login";
        }
        map.put("msg","用户名不存在");
        return "login";
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "login";
    }

}
