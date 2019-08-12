package com.mall.food.mapper;

import com.mall.food.pojo.Advertisement;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AdvertisementMapper {
    @Select("select * from advertisement where adv_id=#{advId}")
    public Advertisement selectAdvertisementById(String advId);

    @Select("select * from advertisement")
    public List<Advertisement> selectAll();

    @Insert("insert into advertisement(com_id,picture,describe) values(#{comId},#{picture},#{describe}")
    public void insert(Advertisement advertisement);

    @Delete("delete advertisement where adv_id=#{advId}")
    public void deleteAdvertisementById(String advId);

    @Update("update advertisement set picture=#{picture},describe=#{describe} where adv_id=#{advId}")
    public void update(Advertisement advertisement);
}
