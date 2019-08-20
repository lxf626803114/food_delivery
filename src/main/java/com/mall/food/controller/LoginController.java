package com.mall.food.controller;

import com.mall.food.mapper.AdministratorMapper;
import com.mall.food.pojo.Administrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private AdministratorMapper administratorMapper;

    @RequestMapping("/login")
    public String login(String aName, String password, HttpSession session, Map<String, Object> map) {
        Administrator administrator = administratorMapper.selectByAname(aName);
        if (administrator != null) {
            if (password.equals(administrator.getPassword())) {
                session.setAttribute("aName", aName);
                return "redirect:ma.html";
            }
            map.put("msg", "密码错误");
            return "login";
        }
        map.put("msg", "用户名不存在");
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "login";
    }


    @RequestMapping("/register")
    public String register(String aName, String password,String repassword ,String tel) {
        if (password.equals(repassword)) {
            List<Administrator> administrators = administratorMapper.selectAll();
            for (Administrator administrator : administrators) {
                if (!administrator.getATel().equals(tel)) {
                    Administrator a = new Administrator();
                    a.setAId(tel);
                    a.setATel(tel);
                    a.setPassword(password);
                    a.setAName(aName);
                    administratorMapper.insert(a);
                    return "login.html";
                }else {
                    return "register.html";
                }
            }
        }
        return "register.html";
    }

    @RequestMapping(value = "/tel",method = RequestMethod.GET)
    @ResponseBody
    public Object tel(String phone) {
        List<Administrator> administrators = administratorMapper.selectAll();
        Map<String,String> map = new HashMap<>();
        for (Administrator administrator : administrators) {
            if (administrator.getATel().equals(phone)){
                    map.put("telTest","电话已被注册");
                    return map;
            }
        }
        return map;
    }

    @RequestMapping(value = "/passwordTest",method = RequestMethod.GET)
    @ResponseBody
    public Object password(String password, String repassword) {
        Map<String,String> map = new HashMap<>();
        if (!password.equals(repassword)) {
            map.put("msg", "两次密码不一致");
            return map;
        }
        return map;
    }
}
