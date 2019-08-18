package com.mall.food.pojo;
import lombok.Data;

@Data
public class Coupon {
    private Integer coupon;
    private String describes;
    private Integer condition;
    private Integer amount;
    private String icon;
}
