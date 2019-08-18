package com.mall.food.mapper;

import com.mall.food.pojo.Coupon;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CouponMapper {
    @Select("select* from coupon")
    List<Coupon> selAllCoupons();
    @Select("select * from coupon where coupon = #{coupon}")
     Coupon selCouponByType(Integer coupon);
    @Insert("insert into coupon(describes,toplimit,amount,numbers,icon) values(#{describes},#{toplimit},#{amount},#{numbers},#{icon})")
    void insert(Coupon coupon);
    @Update("update coupon set describes=#{describes},toplimit=#{toplimit},amount=#{amount},numbers=#{numbers},icon=#{icon} where coupon=#{coupon}")
    void update(Coupon coupon);
    @Delete("delete from coupon where coupon =#{coupon}")
    void deleteById(Integer coupon);
}
