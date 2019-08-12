package com.mall.food.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ShoppingCarMapper {
    @Select("select* from Shopping_Car")
    public List<ShoppingCarMapper> selAllShoppingCars();
    @Select("select* from ShoppingCar where car_id = {#CarId}")
    public List<ShoppingCarMapper> selShoppingCarById(Integer CarId);
}
