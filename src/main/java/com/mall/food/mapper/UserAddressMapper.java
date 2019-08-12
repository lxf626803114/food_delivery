package com.mall.food.mapper;


import com.mall.food.pojo.UserAddress;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserAddressMapper {

    @Select("select * from user_address where add_id = #{addId}")
    public UserAddress selectUserAddressById(Integer addId);

    @Select("select * from user_address")
    public List<UserAddress> selectAll();

    @Insert("insert into user_address(user_id,address,name,tel) values(#{userId},#{address},#{name},#{tel}) ")
    public void insertUserAddress(UserAddress userAddress);

    @Update("update user_address set user_id = #{userId},address = #{address},name = #{name},tel = #{tel} where add_id = #{addId}")
    public void updateUserAddress(Integer addId);

    @Delete("delete from user_address where add_id = #{addId}")
    public void deleteUserAddressByAddId(Integer addId);

}
