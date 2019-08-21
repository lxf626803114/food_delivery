package com.mall.food.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mall.food.pojo.Coupon;
import com.mall.food.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/coupon/")
public class CouponController {
    @Autowired
    private CouponService couponService;
      @GetMapping("alls")
      public String findAll(Model model, @RequestParam(value = "p",defaultValue = "1") Integer pages){
          PageHelper.startPage(pages,5);
        List<Coupon> list=couponService.getAll();
          PageInfo<Coupon> page=new PageInfo<>(list);
        model.addAttribute("page",page);
         return "coupon";
      }
      //查询单条数据，判断是否为空。对应进行添加或修改
      @GetMapping("add/{coupon}")
      public String fingOne(@PathVariable Integer coupon, Model model){
          Coupon coupon1=couponService.selectOne(coupon);
          model.addAttribute("coupon",coupon1);
          return "couponAdd";
      }
      //修改方法的调用
      @PutMapping("add")
      public  String modify(Coupon coupon){
         couponService.update(coupon);
         //修改完重定向到查询列表
         return "redirect:/coupon/alls";
      }
      //进入添加页面
      @GetMapping("add")
      public String init(){
          return "couponAdd";
      }
      //实现添加功能后重定向到查询列表
      @PostMapping("add")
      public String insert(Coupon coupon){
          couponService.insert(coupon);
          return "redirect:/coupon/alls";
      }

      @DeleteMapping("add/{coupon}")
      public String delete(@PathVariable Integer coupon){
          couponService.delete(coupon);
          return "redirect:/coupon/alls";
      }

}
