package com.mall.food;

import com.mall.food.mapper.AdvertisementMapper;
import com.mall.food.mapper.CommodityTypeMapper;
import com.mall.food.mapper.UserCustomerMapper;
import com.mall.food.pojo.Advertisement;
import com.mall.food.pojo.CommodityType;
import com.mall.food.pojo.UserCustomer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.util.pattern.PathPattern;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FoodDeliveryApplicationTests {

    @Autowired
    private AdvertisementMapper advertisementMapper;
    @Autowired
    private UserCustomerMapper userCustomer;
    @Autowired
    private CommodityTypeMapper commodityTypeMapper;
    @Autowired
    private UserCustomerMapper userCustomerMapper;
    @Test
    public void contextLoads() {

    }

}
