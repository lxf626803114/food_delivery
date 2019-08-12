package com.mall.food.mapper;


import com.mall.food.pojo.UserCoupon;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserCouponMapper {
    @Select("select * from user_coupon where coupon_id = #{couponId}")
    public UserCoupon selectUserCouponById(Integer addId);

    @Select("select * from user_coupon")
    public List<UserCoupon> selectAll();

    @Insert("insert into user_coupon(coupon,user_id,describe) values(#{coupon},#{userId},#{describe}) ")
    public void insertUserCoupon(UserCoupon userAddress);

    @Update("update user_coupon set coupon = #{coupon},user_id = #{userId},describe = #{describe} where coupon_id = #{couponId}")
    public void updateUserCoupon(Integer addId);

    @Delete("delete from user_coupon where coupon_id = #{couponId}")
    public void deleteUserCouponByAddId(Integer addId);
}
