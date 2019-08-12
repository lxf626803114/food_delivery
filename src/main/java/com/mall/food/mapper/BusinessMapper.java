package com.mall.food.mapper;

import com.mall.food.pojo.Business;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BusinessMapper {
    @Select("select * from business where b_id=#{bId}")
    public Business selectBusinessById(String bId);

    @Select("select * from business")
    public List<Business> selectAll();

    @Insert("insert into business(b_id,b_name,password,b_tel,b_email,key,boss_name,age,sex,address,balance,b_picture,b_logo)" +
            "values(#{bId},#{bName},#{password},#{bTel},#{bEmail},#{key},#{bossName},#{age},#{sex},#{address},#{balance},#{bPicture},#{bLogo}")
    public void insert(Business business);

    @Delete("delete business where b_id=#{bId}")
    public void deleteBusinessById(String bId);

    @Update("update business set b_name=#{bName},password=#{password},b_tel=#{bTel}," +
            "b_email=#{bEmail},key=#{key},boss_name=#{bossName},age=#{age},sex=#{sex}," +
            "address=#{address},balance=#{balance},b_picture=#{bPicture},b_logo=#{b_logo} " +
            "where a_id=#{aId}")
    public void update(Business business);
}

