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
      List<Business> businesses=businessMapper.selectLikeBusiness(bId);
      map.addAttribute("businesses",businesses);
      return "business_list";
    }


}
