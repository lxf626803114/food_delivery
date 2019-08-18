package com.mall.food.service;

import com.mall.food.mapper.UserCustomerMapper;
import com.mall.food.pojo.UserCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = "UsercustomerCache")
public class UserCustomerService {
    @Autowired
    private UserCustomerMapper userCustomerMapper;

    @Cacheable(value = "usercustomerList", key = "getTargetClass()+getMethodName()")
    public List<UserCustomer> userCustomergetAll() {
        return userCustomerMapper.selectAll();

    }

    @Cacheable(value = "usermemeberOne", key = "getTargetClass()+getMethodName()")
    public List<UserCustomer> selectMember() {
        return userCustomerMapper.selectmember();
    }

    @Cacheable(value = "usercustomerupdateList", key = "getTargetClass()+getMethodName()")
    public void updateUserCustomer(UserCustomer userCustomer) {
        userCustomerMapper.updateUserCustomer(userCustomer);

    }
}
