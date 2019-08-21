package com.mall.food.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mall.food.mapper.BusinessMapper;
import com.mall.food.pojo.Business;
import com.mall.food.service.BusinessmManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BusinessManagerController {
    @Autowired
    private BusinessmManagerService bms;


    @Autowired
    private BusinessMapper businessMapper;
      @RequestMapping("/business_list")
    public  String  BusinessAll(Model model,@RequestParam(value = "p",defaultValue = "1") Integer pageNum){
          PageHelper.startPage(pageNum,5);
         List<Business> businesses =bms.findAll();
         PageInfo<Business> page=new PageInfo<>(businesses);
         model.addAttribute("page",page);
         return "business_list";
    }
    @DeleteMapping("/business/{BId}")
    public  String deleteBusiness(@PathVariable String  BId){
        businessMapper.deleteBusinessById(BId);
        return "redirect:/business_list";
    }
@RequestMapping("/businessid")
    public  String  LikeBusiness(String bId , Model map,@RequestParam(value = "p",defaultValue = "1") Integer pageNum){
        List<Business> businesses=null;
      if(!bId.equals("")&&bId!=null){
          PageHelper.startPage(pageNum,5);
          businesses=businessMapper.selectLikeBusiness(bId);
      }else{

          PageHelper.startPage(pageNum,5);
          businesses=businessMapper.selectAll();
      }
     PageInfo<Business> page=new PageInfo<>(businesses);

     map.addAttribute("page",page);
     map.addAttribute("bId",bId);
      return "business_list";
    }

}
