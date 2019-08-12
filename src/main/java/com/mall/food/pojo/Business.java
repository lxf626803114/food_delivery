package com.mall.food.pojo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Business {
    private String bId;
    private String bName;
    private String password;
    private String bTel;
    private String bEmail;
    private String key;
    private String bossName;
    private Integer age;
    private String sex;
    private String address;
    private BigDecimal balance;
    private String bPicture;
    private String bLogo;

}
