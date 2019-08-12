package com.mall.food.service;

import com.mall.food.mapper.AdvertisementMapper;
import com.mall.food.pojo.Advertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = "AdvertisementCache")
public class AdministratorService {
    @Autowired
    private AdvertisementMapper advertisementMapper;

    @Cacheable(value = "advertisementList",key = "targetClass+getMethodName()")
    public List<Advertisement> getAll(){
        return advertisementMapper.selectAll();
    }
}
