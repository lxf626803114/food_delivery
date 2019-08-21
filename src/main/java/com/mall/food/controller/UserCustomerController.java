package com.mall.food.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mall.food.mapper.UserCustomerMapper;
import com.mall.food.pojo.Business;
import com.mall.food.pojo.UserCustomer;
import com.mall.food.service.UserCustomerService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserCustomerController {
    @Autowired
    private UserCustomerService userCustomerService;
    @Autowired
    private UserCustomerMapper userCustomerMapper;

    /*  @GetMapping("/user_list")
      public String  userCustomer(ModelMap map){
         List<UserCustomer> userCustomers=userCustomerService.userCustomergetAll();
          map.addAttribute("userCustomers",userCustomers);
          return "user_list";
      }*/
    @GetMapping("/user_list")
    public String findAll(Model model, @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        PageHelper.startPage(pageNum, 5);
        List<UserCustomer> userCustomers = userCustomerService.userCustomergetAll();
        PageInfo<UserCustomer> page = new PageInfo<>(userCustomers);
        System.out.println(page.getSize());
        model.addAttribute("page", page);
        return "user_list";
    }

    @RequestMapping("/usercustomer")
    public String LikeUserId(String userId, Model model, @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        PageHelper.startPage(pageNum, 5);
        List<UserCustomer> userCustomers = userCustomerMapper.selectLikeName(userId);
        PageInfo<UserCustomer> page = new PageInfo<>(userCustomers);
        model.addAttribute("page", page);
        return "user_list";
    }


    /* @GetMapping("/usercustomer/{userId}")
    public  String  getUserCustomer( @PathVariable String  userId, Model model ) {
        UserCustomer userCustomer= userCustomerMapper.selectUserCustomerByUserId(userId);
         model.addAttribute("userCustomer",userCustomer);
         return "edit_user";*//*
    }*/
    @DeleteMapping("/usercustomer/{userId}")
    public String deleteUser(@PathVariable String userId) {
        userCustomerMapper.deleteUserCustomer(userId);
        return "redirect:/user_list";
    }

    /* @GetMapping("/member_list")
     public String  userCustomerMemeber(ModelMap map){
         List<UserCustomer> usermembers  = userCustomerService.selectMember();
         map.addAttribute("usermembers",usermembers);
         return "member_list";

     }*/
    @GetMapping("member_list")
    public String findAllmember(Model model, @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        PageHelper.startPage(pageNum, 5);
        List<UserCustomer> usermembers = userCustomerService.selectMember();
        PageInfo<UserCustomer> page = new PageInfo<>(usermembers);
        System.out.println(page.getSize());
        model.addAttribute("page", page);
        return "member_list";
    }

    @RequestMapping("/usermember/{userId}")
    public String getUserCustomer(@PathVariable String userId) {
        UserCustomer userCustomer = userCustomerMapper.selectUserCustomerByUserId(userId);
        userCustomer.setMember(0);
        userCustomerService.updateUserCustomer(userCustomer);
        return "redirect:/member_list";
    }

    @RequestMapping("/member")
    public String getLikeMember(String memberuserid, Model model, @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        PageHelper.startPage(pageNum, 5);
        List<UserCustomer> usermembers = userCustomerMapper.selectLikemember(memberuserid);
        PageInfo<UserCustomer> page = new PageInfo<>(usermembers);
        model.addAttribute("page", page);
        return "member_list";
    }

}
