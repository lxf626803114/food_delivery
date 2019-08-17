package com.mall.food.mapper;

import com.mall.food.pojo.Advertisement;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AdvertisementMapper {
    @Select("select * from advertisement where adv_id=#{advId}")
    public Advertisement selectAdvertisementById(Integer advId);

    @Select("select * from advertisement")
    public List<Advertisement> selectAll();

    @Insert("insert into advertisement(com_id,picture,describes) values(#{comId},#{picture},#{describes})")
    public void insert(Advertisement advertisement);

    @Delete("delete from advertisement where adv_id=#{advId}")
    public void deleteAdvertisementById(Integer advId);

    @Update("update advertisement set com_id=#{comId},picture=#{picture},describes=#{describes} where adv_id=#{advId}")
    public void update(Advertisement advertisement);
}
