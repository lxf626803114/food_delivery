package com.mall.food.controller;

import com.mall.food.pojo.Coupon;
import com.mall.food.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/coupon/")
public class CouponController {
    @Autowired
    private CouponService couponService;
      @GetMapping("alls")
      public String findAll(Model model){
        List<Coupon> list=couponService.getAll();
        model.addAttribute("coupons",list);
         return "coupon";
      }

}
