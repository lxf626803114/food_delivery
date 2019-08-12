package com.mall.food.mapper;

import com.mall.food.pojo.OrderSchedule;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OrderScheduleMapper {
    @Select("select* from Order_Schedule")
    public List<OrderSchedule> selAllOrderSchedules();
    @Select("select* from OrderSchedule where schedule = #{schedule}")
    public OrderSchedule selOrderScheduleById(String schedule);
}
