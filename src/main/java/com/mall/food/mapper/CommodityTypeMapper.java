package com.mall.food.mapper;

import com.mall.food.pojo.CommodityType;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CommodityTypeMapper {

    @Select("select * from commodity_type")
    public List<CommodityType> selectAll();

    @Select("select * from commodity_type where type = #{type}")
    public CommodityType selectByType(String type);

    @Insert("insert into commodity_type(type,describes) values(#{type},#{describes})")
    public void insert(CommodityType commodityType);

    @Update("update commodity_type set type = #{type},describes = #{describes} where type = #{type}")
    public void update(CommodityType commodityType);

    @Delete("delete from commodity_type where type = #{type}")
    public void deleteByType(String type);

}
