package com.mall.food.mapper;


import com.mall.food.pojo.UserDeal;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserDealMapper {

    @Select("select * from user_deal where user_deal = #{userDeal}")
    public UserDeal selectUserDealByUserDeal(Integer userDeal);

    @Select("select * from user_deal")
    public List<UserDeal> selectAll();

    @Insert("insert into user_deal(user_id,com_id,ord_id,b_id,balance) values(#{userId},#{comId},#{ordId},#{bId},#{balance})")
    public void insertUserDeal(UserDeal userDeal);

    @Update("update user_deal set user_id = #{userId},com_id = #{comId},ord_id = #{ordId},b_id = #{bId},balance = #{balance} where user_deal = #{userDeal}")
    public void  updateUserDeal(Integer userDeal);

    @Delete("delete from user_deal where user_deal = #{userDeal}")
    public void deleteUserDeal(Integer userDeal);
}
