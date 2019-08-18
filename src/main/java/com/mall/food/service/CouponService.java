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

    public Coupon selectOne(Integer coupon){
        Coupon coupon1=couponMapper.selCouponByType(coupon);
        return  coupon1;
    }
    public void insert(Coupon coupon){
        couponMapper.insert(coupon);
    }
    public void update(Coupon coupon){
        couponMapper.update(coupon);
    }
    public void delete(Integer coupon){
        couponMapper.deleteById(coupon);
    }

}
