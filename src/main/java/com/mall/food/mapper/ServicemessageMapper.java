package com.mall.food.mapper;

import com.mall.food.pojo.ServiceMessage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ServicemessageMapper {
    @Select("select * from service_message")
    List<ServiceMessage> selectAll();
    @Select("select * from service_message where service_id=#{serviceId}")
    ServiceMessage selectOne(Integer serviceId);
    @Insert("insert into service_message(sender_id,sender_name,service_content,recipient_id) values(#{senderId},#{senderName},#{serviceContent},#{recipientId})")
    void insert(ServiceMessage serviceMessage);
}
