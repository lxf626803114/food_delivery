package com.mall.food.mapper;

import com.mall.food.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OrderMapper {
    @Select("select* from orders")
    public List<Order> selAllOrders();
    @Select("select* from order where ord_id = {#ordId}")
    public Order selOrderById(Integer ordId);
}
