package com.mall.food.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mall.food.mapper.UserCustomerMapper;
import com.mall.food.pojo.UserCustomer;
import com.mall.food.service.UserCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserCustomerController {
    @Autowired
    private UserCustomerService  userCustomerService;
    @Autowired
    private UserCustomerMapper userCustomerMapper;
    @GetMapping("/user_list")
    public String  userCustomer(ModelMap map,@RequestParam(value = "p",defaultValue = "1") Integer pageNum){
        PageHelper.startPage(pageNum,5);
       List<UserCustomer> userCustomers=userCustomerService.userCustomergetAll();
        PageInfo<UserCustomer> page=new PageInfo<>(userCustomers);
        map.addAttribute("page",page);
        return "user_list";
    }

    @RequestMapping("/usercustomer")
    public String  LikeUserId(String userId, Model map, @RequestParam(value = "p",defaultValue = "1") Integer pageNum ){
        List<UserCustomer> userCustomers=null;
        if(!userId.equals("")&&userId!=null){
            PageHelper.startPage(pageNum,5);
            userCustomers=userCustomerMapper.selectLikeName(userId);
        }else{
            PageHelper.startPage(pageNum,5);
            userCustomers=userCustomerMapper.selectAll();
        }
        PageInfo<UserCustomer> page=new PageInfo<>(userCustomers);
        map.addAttribute("page",page);
        map.addAttribute("userId",userId);
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
    public String  userCustomerMemeber(Model map,@RequestParam(value = "p",defaultValue = "1") Integer pageNum){
        PageHelper.startPage(pageNum,5);
        List<UserCustomer> usermembers  = userCustomerService.selectMember();
        PageInfo<UserCustomer> pages=new PageInfo<>(usermembers);
        map.addAttribute("page",pages);
        return "member_list";

    }

    @RequestMapping("/usermember/{userId}")
   public  String  getUserCustomer(@PathVariable String  userId){
          UserCustomer userCustomer= userCustomerMapper.selectUserCustomerByUserId(userId);
          userCustomer.setMember(0);
          userCustomerService.updateUserCustomer(userCustomer);
         return "redirect:/member_list";
    }

     @RequestMapping("/member")
    public  String  getLikeMember(String memberuserid ,Model map,@RequestParam(value = "p",defaultValue = "1") Integer pageNum){
        List<UserCustomer> usermembers=null;
        PageHelper.startPage(pageNum,5);
        if(!memberuserid.equals("")&&memberuserid!=null){
            usermembers=userCustomerMapper.selectLikemember(memberuserid);
        }else{
            usermembers=userCustomerMapper.selectmember();
        }
        PageInfo<UserCustomer> page=new PageInfo<>(usermembers);
        map.addAttribute("page",page);
        map.addAttribute("memberuserid",memberuserid);
        return "member_list";
     }

}
