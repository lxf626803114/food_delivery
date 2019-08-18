package com.mall.food.service;

import com.mall.food.mapper.BusinessMapper;
import com.mall.food.pojo.Business;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = "BusinessCache")
public class BusinessmManagerService {

    @Autowired
    private BusinessMapper businessMapper;
    @Cacheable(value = "BusinessList", key = "getTargetClass()+getMethodName()")
    public List<Business> findAll(){
        return  businessMapper.selectAll();
    }
}
