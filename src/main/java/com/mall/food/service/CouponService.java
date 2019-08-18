package com.mall.food.service;

import com.mall.food.mapper.CouponMapper;
import com.mall.food.pojo.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponService {
    @Autowired
    private CouponMapper couponMapper;
    public List<Coupon> getAll(){
        return  couponMapper.selAllCoupons();
    }

}
