package com.mall.food.controller;

import com.mall.food.mapper.BusinessMapper;
import com.mall.food.pojo.Business;
import com.mall.food.service.BusinessmManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BusinessManagerController {
    @Autowired
    private BusinessmManagerService bms;


    @Autowired
    private BusinessMapper businessMapper;
      @RequestMapping("/business_list")
    public  String  BusinessAll(Model model){
         List<Business> businesses =bms.findAll();
         model.addAttribute("businesses",businesses);
         return "business_list";
    }
    @DeleteMapping("/business/{BId}")
    public  String deleteBusiness(@PathVariable String  BId){
        businessMapper.deleteBusinessById(BId);
        return "redirect:/business_list";
    }
@RequestMapping("/businessid")
    public  String  LikeBusiness(String bId , ModelMap map){
      List<Business> businesses=   businessMapper.selectLikeBusiness(bId);
      map.addAttribute("businesses",businesses);
      return "business_list";
    }
    @GetMapping("businesspage/{num}")
    public String  userList(Model model,@PathVariable Integer num){
        if(num==null){
            num=1;
        }
        //所有数据
        List<Business> businesses =businessMapper.selectAll();
        //页面展示数据
        List<Business> list = new ArrayList<>();
        for(int i =10;i>0;i--){
            if ((10*num-i) < businesses.size()){
                list.add(businesses.get(10*num-i));
            }
        }
        //页码
        int[] count = new int[businesses.size()/10+1];
        for (int j = 0; j < businesses.size()/10+1; j++){
            count[j] = j+1;
        }

        model.addAttribute("count",count);
        model.addAttribute("size",businesses.size());
        model.addAttribute("users",list);
        return  "admin-list";
    }
}
