package com.mall.food.pojo;

import lombok.Data;

@Data
public class ShoppingCar {
    private Integer carId;
    private String userId;
    private String userName;
    private Integer comId;
    private Integer price;
    private Integer quantity;
    private String size;
    private String describe;
    private String picture;
    private Integer addId;
    private String address;
}
