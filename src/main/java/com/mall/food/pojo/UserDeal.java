package com.mall.food.pojo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserDeal {
    private Integer userDeal;
    private String userId;
    private Integer comId;
    private Integer ordId;
    private String bId;
    private BigDecimal balance;
}
