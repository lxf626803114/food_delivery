package com.mall.food.pojo;
import lombok.Data;

@Data
public class Coupon {
    private Integer coupon;
    private String describe;
    private Integer condition;
    private Integer amount;
    private String icon;
}
