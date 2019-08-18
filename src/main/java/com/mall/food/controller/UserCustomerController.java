package com.mall.food.controller;

import com.mall.food.mapper.UserCustomerMapper;
import com.mall.food.pojo.UserCustomer;
import com.mall.food.service.UserCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserCustomerController {
    @Autowired
    private UserCustomerService  userCustomerService;
    @Autowired
    private UserCustomerMapper userCustomerMapper;
    @GetMapping("/user_list")
    public String  userCustomer(ModelMap map){
       List<UserCustomer> userCustomers=userCustomerService.userCustomergetAll();
        map.addAttribute("userCustomers",userCustomers);
        return "user_list";
    }

    @RequestMapping("/usercustomer")
    public String  LikeUserId(String userId, ModelMap map ){
        List<UserCustomer> userCustomers=userCustomerMapper.selectLikeName(userId);
        map.addAttribute("userCustomers",userCustomers);
        return "user_list";
    }


    /* @GetMapping("/usercustomer/{userId}")
    public  String  getUserCustomer( @PathVariable String  userId, Model model ) {
        UserCustomer userCustomer= userCustomerMapper.selectUserCustomerByUserId(userId);
         model.addAttribute("userCustomer",userCustomer);
         return "edit_user";*//*
    }*/
    @DeleteMapping("/usercustomer/{userId}")
    public  String deleteUser(@PathVariable String  userId){
        userCustomerMapper.deleteUserCustomer(userId);
        return "redirect:/user_list";
    }
    @GetMapping("/member_list")
    public String  userCustomerMemeber(ModelMap map){
        List<UserCustomer> usermembers  = userCustomerService.selectMember();
        map.addAttribute("usermembers",usermembers);
        return "member_list";

    }

    @RequestMapping("/usermember/{userId}")
   public  String  getUserCustomer(@PathVariable String  userId){
          UserCustomer userCustomer= userCustomerMapper.selectUserCustomerByUserId(userId);
          userCustomer.setMember(0);
          userCustomerService.updateUserCustomer(userCustomer);
         return "redirect:/member_list";
    }

}
