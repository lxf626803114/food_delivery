package com.mall.food.mapper;

import com.mall.food.pojo.UserCustomer;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserCustomerMapper {

    @Select("select * from user_customer where user_id = #{userId}")
    public UserCustomer selectUserCustomerByUserId(String userId);

    @Select("select * from user_customer where user_id LIKE '%' || 'userId' || '%'")
      public List<UserCustomer> selectLikeName(String userId);

    @Select("select * from user_customer")
    public List<UserCustomer> selectAll();

    @Select("select * from user_customer where member=1")
    public List<UserCustomer>  selectmember();

    @Insert("insert into user_customer(user_id,user_name,password,tel,email,key,name,age,sex,address,idcard,birthday,job,balance,member ) " +
            "values(#{userId},#{userName},#{password},#{tel},#{email},#{key},#{name},#{age},#{sex},#{address},#{idcard},#{birthday},#{job},#{balance},#{member})")
    public void insertUserCustomer(UserCustomer userCustomer);

    @Update("update user_customer set member = #{member}  where user_id = #{userId}")
            /*("update user_customer set user_name = #{userName},password = #{password},tel = #{tel},email = #{email},key = #{key},name = #{name},age = #{age},sex = #{sex},address = #{address},idcard = #{idCard},birthday = #{birthday},job = #{job},balance = #{balance},member = #{member}  where user_id = #{userId}")
  */  public void updateUserCustomer(UserCustomer userCustomer);

    @Delete("delete from user_customer where user_id = #{userId}")
    public void deleteUserCustomer(String userId);
}
