package com.mall.food.mapper;

import com.mall.food.pojo.Administrator;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AdministratorMapper {
    @Select("select * from administrator where a_id=#{aId}")
    public Administrator selectAdministratorById(String aId);

    @Select("select * from administrator where a_name = #{aName}")
    public Administrator selectByAname(String aName);

    @Select("select * from administrator")
    public List<Administrator> selectAll();

    @Insert("insert into administrator(a_id,password,a_name,a_tel,a_email,a_head) values(#{aId},#{password},#{aName},#{aTel},#{aEmail},#{aHead})")
    public void insert(Administrator administrator);

    @Delete("delete administrator where a_id=#{aId}")
    public void deleteAdministratorById(String aId);

    @Update("update administrator set password=#{password},a_name=#{aName},a_tel=#{aTel},a_email=#{aEmail},a_head=#{aHead} where a_id=#{aId}")
    public void update(Administrator administrator);
}
