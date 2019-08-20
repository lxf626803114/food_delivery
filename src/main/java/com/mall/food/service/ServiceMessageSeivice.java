package com.mall.food.service;


import com.mall.food.mapper.ServicemessageMapper;
import com.mall.food.pojo.ServiceMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceMessageSeivice {
    @Autowired
    private ServicemessageMapper servicemessageMapper;
    public List<ServiceMessage> selectAll(){
        return servicemessageMapper.selectAll();
    }
    public ServiceMessage selectOne(Integer serviceId){

            return  servicemessageMapper.selectOne(serviceId);
    }
    public void insert(ServiceMessage serviceMessage){
            servicemessageMapper.insert(serviceMessage);
    }
}
