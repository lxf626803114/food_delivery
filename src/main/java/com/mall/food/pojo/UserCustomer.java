package com.mall.food.pojo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class UserCustomer {

    private String userId;
    private String userName;
    private String password;
    private String tel;
    private String email;
    private String key;
    private String name;
    private Integer age;
    private String sex;
    private String address;
    private String idCard;
    private Date birthday;
    private String job;
    private BigDecimal balance;
    private Integer member;

}
